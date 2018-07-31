# Spring Data Redis Repository 实现例子

**将redis作为持久化对象，可通过类似jpa的实现方式来操作redis**

注意没有标注`@Indexed`注解的属性是不能作为查询条件进行数据查询的