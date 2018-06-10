package com.example.smlr.service

import org.junit.Test
import org.junit.Assert.assertEquals

class DefaultKeyMapperServiceTest {
    val service: KeyMapperService = DefaultKeyMapperService()

    private val KEY = "test"
    private val LINK = "http://google.com"
    private val LINK_NEW = "http://blabla.com"

    @Test
    fun clientCanAddNewKeyWithLink() {
        assertEquals(KeyMapperService.Add.Success(KEY, LINK), service.add(KEY, LINK))
        assertEquals(KeyMapperService.Get.Link(LINK), service.getLink(KEY))
    }

    @Test
    fun clientCanNotAddExistingKey() {
        service.add(KEY, LINK)
        assertEquals(KeyMapperService.Add.AlreadyExist(KEY), service.add(KEY, LINK_NEW))
        assertEquals(KeyMapperService.Get.Link(LINK), service.getLink(KEY))
    }

    @Test
    fun clientCanNotGetLinkIfKeyNotFound() {
        assertEquals(KeyMapperService.Get.NotFound(KEY), service.getLink(KEY))
    }
}