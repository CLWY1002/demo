/**
 * Title: Demo2Service.java<br/>
 * Description: <br/>
 * Copyright: Copyright (c) 2015<br/>
 * Company: gigold<br/>
 */
package com.gigold.pay.demo.service;

import com.gigold.pay.framework.base.transaction.GigoldTransactionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import com.gigold.pay.demo.bo.Person;
import com.gigold.pay.demo.dao.DemoDAO;
import com.gigold.pay.framework.core.Domain;
import com.gigold.pay.framework.core.exception.AbortException;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * Title: Demo2Service<br/>
 * Description: <br/>
 * Company: gigold<br/>
 *
 * @author Devin
 * @date 2015年9月28日上午11 :55:23
 */
@Service
public class Demo2Service extends Domain {

    @Autowired
    private DemoService         service;

    @Autowired
    private DemoDAO             dao;

    @Autowired
    private GigoldTransactionTemplate newTransactionTemplate;

    /**
     * Add person string.
     *
     * @param p the p
     * @return the string
     * @throws AbortException the abort exception
     */
    public Long addPerson(final Person p) {
       

        // 事务模版开启事务
        Long personId = newTransactionTemplate.execute(new TransactionCallback<Long>() {
            public Long doInTransaction(TransactionStatus status) {
                try {
                    dao.addPerson(p);
                    debug("调用addPerson");
                    p.setName(p.getName() + "我是第二条");
                    return service.addPerson(p);
                } catch (AbortException ae) {
                    warn("新增出错", ae);
                    // 事务回滚
                    status.setRollbackOnly();
                    return null;
                } catch (Exception e) {
                    warn("新增出错", e);
                    // 事务回滚
                    status.setRollbackOnly();
                    return null;
                }
            }
        });

        return personId;
    }

    /**
     * Modify person boolean.
     *
     * @param p the p
     * @return the boolean
     * @throws AbortException the abort exception
     */
    public boolean modifyPerson(Person p) throws AbortException {
        debug("调用modifyPerson");
        return service.modifyPerson(p);
    }

    /**
     * Query person.
     *
     * @param name the name
     * @return the person
     */
    public Person query(String name) {
        Person p = new Person();
        p.setName(name);
        return service.query(p);
    }

    /**
     * Sets dao.
     *
     * @param dao the dao
     */
    public void setDao(DemoDAO dao) {
        this.dao = dao;
    }

    /**
     * Sets service.
     *
     * @param service the service
     */
    public void setService(DemoService service) {
        this.service = service;
    }

    /**
     * Sets transaction template.
     *
     * @param newTransactionTemplate the transaction template
     */
    public void setNewTransactionTemplate(GigoldTransactionTemplate newTransactionTemplate) {
        this.newTransactionTemplate = newTransactionTemplate;
    }
}
