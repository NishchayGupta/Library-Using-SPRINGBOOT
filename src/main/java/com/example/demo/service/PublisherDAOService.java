package com.example.demo.service;

import java.util.*;

import org.springframework.stereotype.Component;

import com.example.demo.dao.Author;
import com.example.demo.dao.Publisher;

@Component
public class PublisherDAOService {
	
	private List<Publisher> pubs = new ArrayList<>();
	
	public static int pubCount = 3;
	
	public List<Publisher> getAllPublishers()
	{
		return pubs;
	}
	
	public Publisher getSinglePublisher(int id)
	{
		for(Publisher pub: pubs)
		{
			if(pub.getPublisherId()==id)
			{
				return pub;
			}
		}
		return null;
	}
	
	// To create a publisher
		public Publisher createPublisher(Publisher pub)
		{
			if(pub.getPublisherId() == 0)
			{
				pub.setPublisherId(++pubCount);
			}
			pubs.add(pub);
			return pub;
		}
		
		//To delete a publisher
		public Publisher removePublisher(int id)
		{
			Iterator<Publisher> pubIterator = pubs.iterator();
			while(pubIterator.hasNext())
			{
				Publisher pub = pubIterator.next();
				if(pub.getPublisherId() == id)
				{
					pubIterator.remove();
					return pub;
				}
			}
			return null;
		} 
}