package pl.danowski.rafal.aoc2022

import java.io.File

fun readFromFile(filename: String): List<String> =
    File(object {}.javaClass.getResource(filename)!!.toURI()).readLines()
