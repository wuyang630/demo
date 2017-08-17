package com.example.controller;

import com.example.dao.TBItem;
import com.example.dao.TBItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private TBItemMapper tbItemMapper;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<TBItem> getUserList() {
		List<TBItem> r = tbItemMapper.getTb();
		return r;
	}

	@RequestMapping(value = "/cnt", method = RequestMethod.GET)
	public Long getUserCnt() {
		return tbItemMapper.getCnt();
	}
}
