package com.sprint.saleshistory.entities; 

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;

import jakarta.persistence.GenerationType;

import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;

import lombok.Getter;

import lombok.NoArgsConstructor;

import lombok.Setter;

import lombok.ToString;
 
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name = "channels")
 
public class ChannelEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "channel_id")

    private int channelId;

	@Column(name = "channel_desc", nullable = false)
    private String channelDesc;
 
    @Column(name = "channel_class", nullable = false)
    private String channelClass;
 
    @Column(name = "channel_class_id", nullable = false)
    private int channelClassId;

    @Column(name = "channel_total", nullable = false)
    private String channelTotal;
 
    @Column(name = "channel_total_id", nullable = false)
    private int channelTotalId;
    
  
 
}


