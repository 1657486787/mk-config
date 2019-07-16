package com.suns.config;

import org.springframework.beans.factory.annotation.Value;

public class TestJavaConfigBean {
  @Value("${timeout:100}")
  private int timeout;
  private int batch;
 
  @Value("${batch:200}")
  public void setBatch(int batch) {
    this.batch = batch;
  }
 
  public int getTimeout() {
    return timeout;
  }
 
  public int getBatch() {
    return batch;
  }

  @Value("${k1:100}")
  public String k1;
  @Value("${k2:100}")
  public String k2;

  public String getK1() {
    return k1;
  }

  public void setK1(String k1) {
    this.k1 = k1;
  }

  public String getK2() {
    return k2;
  }

  public void setK2(String k2) {
    this.k2 = k2;
  }

  @Override
  public String toString() {
    return "TestJavaConfigBean{" +
            "timeout=" + timeout +
            ", batch=" + batch +
            ", k1='" + k1 + '\'' +
            ", k2='" + k2 + '\'' +
            '}';
  }
}