package com.bt.springbootstarter.services;

import com.bt.springbootstarter.beans.Topic;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

    List<Topic> topics = new ArrayList<Topic>();
    public List<Topic> getAllTopics(){
        return topics;
    }

    public Topic getTopic(String id){
        return null;
    }

    public void addTopic(Topic topic) {
        topics.add(topic);
    }

    public void updateTopic(Topic topic,String id) {
        for(int i=0 ;i<topics.size();i++){
            Topic t = topics.get(i);
            if(t.getId().equals(id)){
                topics.set(i,topic);
                return;
            }
        }
    }

    public void deleteTopic(String id) {

    }
}
