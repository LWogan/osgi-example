package com.example.osgi.work.test

import com.example.osgi.api.Greetings
import net.corda.core.identity.CordaX500Name
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.osgi.test.common.annotation.InjectService
import org.osgi.test.junit5.service.ServiceExtension

@ExtendWith(ServiceExtension::class)
class WorkerTest {

    @InjectService(timeout = 1000, filter = "(component.name=greetings)")
    lateinit var greetings: Greetings

    @Test
    fun testWork() {

        val x500Name = CordaX500Name.parse("L=London,C=GB,O=TestOSGi")
        println("x500Name = $x500Name")

        val name = "Charlie"
        assertEquals("You are suspended, $name!", greetings.greet(name))
    }
}