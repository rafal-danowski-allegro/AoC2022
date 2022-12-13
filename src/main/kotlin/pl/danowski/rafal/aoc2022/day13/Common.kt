package pl.danowski.rafal.aoc2022.day13

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.int
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonPrimitive

enum class JsonType { INT, ARRAY }

enum class ComparisonResult { LEFT, RIGHT, EQUAL }

fun compare(left: JsonElement, right: JsonElement): ComparisonResult {
    val leftType = determineJsonType(left)
    val rightType = determineJsonType(right)

    return if (leftType == JsonType.INT && rightType == JsonType.INT) {
        compareIntegers(left.jsonPrimitive.int, right.jsonPrimitive.int)
    } else if (leftType == JsonType.ARRAY && rightType == JsonType.ARRAY) {
        compareArrays(left.jsonArray, right.jsonArray)
    } else {
        if (leftType == JsonType.INT && rightType == JsonType.ARRAY) {
            compareArrays(JsonArray(listOf(left)), right.jsonArray)
        } else { // left - array, right - int
            compareArrays(left.jsonArray, JsonArray(listOf(right)))
        }
    }
}

fun determineJsonType(json: JsonElement) =
    try {
        json.jsonPrimitive.int
        JsonType.INT
    } catch (ex: IllegalArgumentException) {
        try {
            json.jsonArray
            JsonType.ARRAY
        } catch (ex: IllegalArgumentException) {
            throw ex
        }
    }

fun compareArrays(left: JsonArray, right: JsonArray): ComparisonResult {
    val minSize = minOf(left.size, right.size)
    repeat(minSize) {
        val comparisonResult = compare(left[it], right[it])
//        println("\t ${left[it]} compared to ${right[it]} = $comparisonResult")
        if (comparisonResult != ComparisonResult.EQUAL) return comparisonResult
    }

    return if (left.size < right.size) ComparisonResult.RIGHT
    else if (left.size > right.size) ComparisonResult.LEFT
    else ComparisonResult.EQUAL
}

fun compareIntegers(left: Int, right: Int) =
    if (left < right) ComparisonResult.RIGHT
    else if (left > right) ComparisonResult.LEFT
    else ComparisonResult.EQUAL

fun parseStringToJson(string: String) = Json.parseToJsonElement(string)
