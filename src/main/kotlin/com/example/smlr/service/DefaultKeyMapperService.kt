package com.example.smlr.service

import org.springframework.stereotype.Component
import java.util.concurrent.ConcurrentHashMap

@Component
class DefaultKeyMapperService: KeyMapperService {

    private val map: MutableMap<String, String> = ConcurrentHashMap()

    override fun add(key: String, link: String): KeyMapperService.Add {
        if (map.containsKey(key)) {
            return KeyMapperService.Add.AlreadyExist(key)
        }

        map.put(key, link)
        return KeyMapperService.Add.Success(key, link)
    }

    override fun getLink(key: String): KeyMapperService.Get {
        if (map.containsKey(key)) {
            return KeyMapperService.Get.Link(map.get(key)!!)
        }

        return KeyMapperService.Get.NotFound(key)
    }
}