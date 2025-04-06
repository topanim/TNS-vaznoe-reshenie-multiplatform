package app.what.gorogeuslugi.security

import java.security.PrivateKey
import java.security.Signature
import java.util.Base64

fun sign(data: ByteArray, privateKey: PrivateKey): String {
    // Создаем объект Signature с алгоритмом SHA256withRSA
    val sig = Signature.getInstance("SHA256withRSA")

    // Инициализируем объект подписи приватным ключом
    sig.initSign(privateKey)

    // Передаем данные для подписи
    sig.update(data)

    // Выполняем подпись и получаем результат в виде массива байтов
    val signature = sig.sign()

    // Кодируем подпись в строку Base64 и возвращаем
    return Base64.getEncoder().encodeToString(signature)
}