package com.trawlbens.hometest.domain.mapper

/**
 * Created by M.Hafidh Abdul Aziz on 08/10/23.
 */
abstract class BaseMapper<in T, out R> {
    abstract fun mapToDomain(value: T): R
}