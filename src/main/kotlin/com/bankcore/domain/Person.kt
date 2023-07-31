package com.bankcore.domain

data class Person(
    val name: PersonName,
    val age: PersonAge
) {
    override fun toString(): String {
        return "Person(name=$name, age=$age)"
    }
}


// Обертка для имени
data class PersonName private constructor(val value: String) {
    companion object {
        fun from(value: String): PersonName {
            if (value.isBlank()) {
                throw IllegalArgumentException("Person name cannot be blank")
            }
            return PersonName(value)
        }
    }

    override fun toString(): String {
        return value
    }
}

// Обертка для возраста
data class PersonAge private constructor(val value: Int) {
    companion object {
        fun from(value: Int): PersonAge {
            if (value < 0) {
                throw IllegalArgumentException("Person age cannot be negative")
            }
            return PersonAge(value)
        }
    }

    override fun toString(): String {
        return value.toString()
    }
}

