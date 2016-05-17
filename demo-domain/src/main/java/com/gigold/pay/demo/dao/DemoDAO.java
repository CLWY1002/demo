/**
 * Title: DemoDAO.java<br/>
 * Description: <br/>
 * Copyright: Copyright (c) 2015<br/>
 * Company: gigold<br/>
 *
 */
package com.gigold.pay.demo.dao;

import java.util.List;

import com.gigold.pay.demo.bo.Person;

/**
 * Title: DemoDAO<br/>
 * Description: DAO的参数可以是基本型，也可以是领域对象，推荐领域对象<br/>
 * Company: gigold<br/>
 * @author Devin
 * @date 2015年9月16日下午2:10:48
 *
 */

public interface DemoDAO {
  public Person search(String name);

  public Person searchForupdate(String name);

  public List<Person> searchALL();

  public Long addPerson(Person p);

  public boolean modifyPerson(Person p);
}
