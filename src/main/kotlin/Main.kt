package ru.netology

fun main() {
    val itemPrice = 100 // Оценка товара за 1шт
    val itemCount = 20// Количество товара

    val discount1 = 100 // Скидка 1 скидка на товар выше 1000р
    val discountPercent2 = 5 // Процент скидки 2 (5%)

    val loyaltyDiscount = 0.01 // Дополнительная скидка для постоянного клиента (1%)

    val totalPrace = itemPrice * itemCount // Цена без скидок

    val isLoyalCustomer = true// Замените на true, если клиент постоянный

    var finalPrice = totalPrace.toDouble() // Изначальная цена

    // Валидация:
    if (itemCount <= 0) {
        println("Ошибка: Количество товаров должно быть больше 0.")
        return
    }
    if (loyaltyDiscount !in 0.0..1.0) {
        println("Ошибка: Скидка для постоянного клиента должна быть в диапазоне от 0 до 1.")
        return
    }

    // Применение скидок:
    if (finalPrice in 1_001.0..10_000.0) {
        finalPrice -= discount1
    }
    if (finalPrice > 10_000.0) {
        finalPrice *= (1 - discountPercent2 / 100.0) // Скидка 2
    }

    // Применение скидки постоянного клиента после всех других скидок:
    if (isLoyalCustomer) {
        finalPrice *= (1 - loyaltyDiscount)
    }

    // Вывод результата:
    println("Итоговая цена: $finalPrice")

    if (finalPrice <= 1_000.0) {
        println("Скидки не применялись.")
    } else if (finalPrice <= 10_000.0) {
        println("Применена скидка 1: $discount1")
    } else {
        println("Применена скидка 2: $discountPercent2%")
    }

    if (isLoyalCustomer) {
        println("Применена скидка для постоянного клиента: $loyaltyDiscount")
    }
}
