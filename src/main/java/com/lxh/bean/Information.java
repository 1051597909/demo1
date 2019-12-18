package com.lxh.bean;


public class Information {

  private long id;
  private String name;
  private String name1;
  private long age;
  private String sex;
  private String education;
  private String phonenumber;
  private String scholl;
  private String professional;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getName1() {
    return name1;
  }

  public void setName1(String name1) {
    this.name1 = name1;
  }


  public long getAge() {
    return age;
  }

  public void setAge(long age) {
    this.age = age;
  }


  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }


  public String getEducation() {
    return education;
  }

  public void setEducation(String education) {
    this.education = education;
  }


  public String getPhonenumber() {
    return phonenumber;
  }

  public void setPhonenumber(String phonenumber) {
    this.phonenumber = phonenumber;
  }


  public String getScholl() {
    return scholl;
  }

  public void setScholl(String scholl) {
    this.scholl = scholl;
  }


  public String getProfessional() {
    return professional;
  }

  public void setProfessional(String professional) {
    this.professional = professional;
  }

  @Override
  public String toString() {
    return "Information{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", name1='" + name1 + '\'' +
            ", age=" + age +
            ", sex='" + sex + '\'' +
            ", education='" + education + '\'' +
            ", phonenumber=" + phonenumber +
            ", scholl='" + scholl + '\'' +
            ", professional='" + professional + '\'' +
            '}';
  }
}
