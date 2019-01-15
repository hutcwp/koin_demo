package com.hutcwp.demo.repository.json

import com.hutcwp.demo.repository.json.geocode.Geocode
import com.hutcwp.demo.repository.json.geocode.Location


fun Geocode.getLocation(): Location? = results.firstOrNull()?.geometry?.location