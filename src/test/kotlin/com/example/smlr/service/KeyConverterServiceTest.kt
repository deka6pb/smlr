package com.example.smlr.service

import org.junit.Test
import java.util.*
import org.junit.Assert.assertEquals

class KeyConverterServiceTest {

    val service: KeyConverterService = DefaultKeyConverterService()

    @Test
    fun givenIdMustBeConvertableBothWays() {
        val rand = Random()

        for (i in 0..1000) {
            val initialId = Math.abs(rand.nextLong())
            val key = service.idToKey(initialId)
            val id = service.keyToId(key)

            assertEquals(initialId, id)
        }
    }
}
