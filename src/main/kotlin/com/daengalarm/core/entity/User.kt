package com.daengalarm.core.domain

import jakarta.persistence.*

@Entity
@Table(name = "user")
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idx: Long = 0;

    @Column(name = "username")
    var username: String? = null;

    
}