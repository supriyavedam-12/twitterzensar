package com.twitter.service;

import com.twitter.DAO.TwitterDAO;
import com.twitter.DAO.TwitterDAOInterface;
import com.twitter.entity.TwitterEmployee;

public class TwitterService implements TwitterServiceInterface
{

	public static TwitterServiceInterface createServiceObject() {
		// TODO Auto-generated method stub
		return new TwitterService();
	}

	@Override
	public int createProfile(TwitterEmployee te) {
		// TODO Auto-generated method stub
		TwitterDAOInterface td=TwitterDAO.createObject();
		
		return td.createProfileDAO(te);
	}
	}
	


