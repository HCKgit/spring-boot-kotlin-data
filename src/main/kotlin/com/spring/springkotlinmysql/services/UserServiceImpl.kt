package com.spring.springkotlinmysql.services

import com.spring.springkotlinmysql.entities.User
import com.spring.springkotlinmysql.repositories.UserRepository
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service



@Service
class UserServiceImpl: UserService {

    private val log = KotlinLogging.logger {}
    @Autowired
    lateinit var repository: UserRepository

    override fun getUsers() =
            repository.findAll()

    override fun getUserById(id: Long) =
            repository.findOne(id)


    override fun getUserByName(firstname: String) =
            repository.findByfirstname(firstname)


    override fun addUser(user: User): User {
        repository.save(user)
        log.info("${user.firstname},added!!!")
        return user


    }

    override fun deleteUser(id: Long) {
        repository.delete(id)
        log.info("user deleted!!")
    }

    override fun deleteAllUsers() {
        repository.deleteAll()
        log.info("All users deleted!!")
    }

    override fun updateUser(id: Long, user: User) {
        assert(user.id == id)
        repository.save(user)
        log.info("${user.firstname},updated!!!")

    }

}

