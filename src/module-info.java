<<<<<<< Updated upstream
module RDM_GitHub {
=======
module rdmGithub {
>>>>>>> Stashed changes
	exports jp.co.takeda.rdm.action;
	exports jp.co.takeda.rdm.common;
	exports jp.co.takeda.rdm.util;
	exports jp.co.takeda.rdm.entity.join;
	exports jp.co.takeda.rdm.common.filter;
	exports jp.co.takeda.rdm.dto;
	exports jp.co.takeda.rdm.exception;
	exports jp.co.takeda.rdm.service;
	exports jp.co.takeda.rdm.entity;

	requires aopalliance;
	requires commons.beanutils;
	requires commons.lang3;
	requires commons.logging;
	requires java.servlet;
	requires java.sql;
	requires javax.inject;
	requires jjwt;
	requires jxl;
	requires lombok;
	requires mybatis;
	requires mybatis.spring;
	requires org.apache.tomcat.util;
	requires spring.beans;
	requires spring.context;
	requires spring.core;
	requires spring.tx;
	requires spring.web;
	requires struts2.core;
	requires xwork.core;
}