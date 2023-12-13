package com.sprint.saleshistory.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint.saleshistory.dao.TimesRepository;
import com.sprint.saleshistory.entities.TimesEntity;
import com.sprint.saleshistory.models.TimesPojo;

@Service
public class TimesServiceImpl implements TimesService {

	private final TimesRepository timesRepository;

	@Autowired
	public TimesServiceImpl(TimesRepository timesRepository) {
		this.timesRepository = timesRepository;
	}

	@Override
	public List<TimesPojo> getAllTimes() {
		List<TimesEntity> allTimesEntity = timesRepository.findAll();
		List<TimesPojo> allTimesPojo = new ArrayList<>();
		for (TimesEntity timesEntity : allTimesEntity) {
			TimesPojo timesPojo = new TimesPojo();
			BeanUtils.copyProperties(timesEntity, timesPojo);
			allTimesPojo.add(timesPojo);
		}
		return allTimesPojo;
	}

//    @Override
//    public TimesPojo getTimesByTimeId(Date timeId) {
//        Optional<TimesEntity> timesEntityOptional = timesRepository.findById(timeId);
//        return timesEntityOptional.map(timesEntity -> {
//            TimesPojo timesPojo = new TimesPojo();
//            BeanUtils.copyProperties(timesEntity, timesPojo);
//            return timesPojo;
//        }).orElse(null);
//    }
//
//    @Override
//    public TimesPojo createTimes(TimesPojo times) {
//        TimesEntity timesEntity = new TimesEntity();
//        BeanUtils.copyProperties(times, timesEntity);
//        TimesEntity savedTimesEntity = timesRepository.save(timesEntity);
//        TimesPojo savedTimesPojo = new TimesPojo();
//        BeanUtils.copyProperties(savedTimesEntity, savedTimesPojo);
//        return savedTimesPojo;
//    }
//
//    @Override
//    public TimesPojo updateTimes(Date timeId, TimesPojo times) {
//        Optional<TimesEntity> existingTimesOptional = timesRepository.findById(timeId);
//        return existingTimesOptional.map(existingTimesEntity -> {
//            BeanUtils.copyProperties(times, existingTimesEntity);
//            TimesEntity updatedTimesEntity = timesRepository.save(existingTimesEntity);
//            TimesPojo updatedTimesPojo = new TimesPojo();
//            BeanUtils.copyProperties(updatedTimesEntity, updatedTimesPojo);
//            return updatedTimesPojo;
//        }).orElse(null);
//    }
//
//    @Override
//    public void deleteTimes(Date timeId) {
//        timesRepository.deleteById(timeId);
//    }
}
