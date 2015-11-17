package com.pvamu.timesheet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pvamu.timesheet.dao.FinanceDAO;

@Component
public class FinanceServiceImpl implements FinanceService {
	@Autowired
	private FinanceDAO dao;
}
