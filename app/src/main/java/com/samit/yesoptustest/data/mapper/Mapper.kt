package com.samit.yesoptustest.data.mapper

import com.samit.yesoptustest.api.OptusApi
import com.samit.yesoptustest.data.OptusUI

fun toOptustUI(optusApi: OptusApi): OptusUI =
    OptusUI(
        id = optusApi.id,
        text = optusApi.name
    )