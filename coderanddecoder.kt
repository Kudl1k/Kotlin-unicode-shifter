import java.io.File

val path = System.getProperty("user.dir")
val separator = File.separator

fun shiftCharEncrypter(inputFile: String, key: Int,outputFile: String){
    var resultText = ""
    var inputText: String = ""
    if (inputFile.contains(".txt")){
        inputText = File("$path$separator$inputFile").readText()
    } else {
        inputText = inputFile
    }
    for (i in inputText.indices){
        if (inputText[i] in 'a'..'z'){
            resultText += ((inputText[i].code - 97 + key + 26) % 26 + 97).toChar()
        } else if (inputText[i] in 'A'..'Z'){
            resultText += ((inputText[i].code - 65 + key + 26) % 26 + 65).toChar()
        } else {
            resultText += inputText[i]
        }
    }
    if (outputFile == ""){
        print(resultText)
    } else if (outputFile.contains(".txt")) {
        File("$path$separator$outputFile").writeText(resultText)
    }
}

fun shiftCharDecrypter(inputFile: String, key: Int,outputFile: String){
    var resultText = ""
    var inputText: String = ""
    if (inputFile.contains(".txt")){
        inputText = File("$path$separator$inputFile").readText()
    } else {
        inputText = inputFile
    }
    for (i in inputText.indices){
        if (inputText[i] in 'a'..'z'){
            resultText += ((inputText[i].code - 97 - key + 26) % 26 + 97).toChar()
        } else if (inputText[i] in 'A'..'Z'){
            resultText += ((inputText[i].code - 65 - key + 26) % 26 + 65).toChar()
        } else {
            resultText += inputText[i]
        }
    }
    if (outputFile == ""){
        print(resultText)
    } else if (outputFile.contains(".txt")) {
        File("$path$separator$outputFile").writeText(resultText)
    }
}


fun encrypter(inputFile: String, key: Int,outputFile: String){
    var resultText = ""
    var inputText: String = ""
    if (inputFile.contains(".txt")){
        inputText = File("$path$separator$inputFile").readText()
    } else {
        inputText = inputFile
    }

    for (i in inputText.indices) {
        resultText += (inputText[i].code + key).toChar()
    }
    if (outputFile == ""){
        print(resultText)
    } else if (outputFile.contains(".txt")) {
        File("$path$separator$outputFile").writeText(resultText)
    }
}

fun decrypter(inputFile: String, key: Int,outputFile: String){
    var resultText = ""
    var inputText: String = ""
    if (inputFile.contains(".txt")){
        inputText = File("$path$separator$inputFile").readText()
    } else {
        inputText = inputFile
    }

    for (i in inputText.indices) {
        resultText += (inputText[i].code - key).toChar()
    }
    if (outputFile == ""){
        print(resultText)
    } else if (outputFile.contains(".txt")) {
        File("$path$separator$outputFile").writeText(resultText)
    }
}

fun main(args: Array<String>){
    var mode: String = ""
    var key: Int = 0
    var data: String = ""
    var outputFile: String = ""
    var alg: String = ""


    for (i in args.indices){
        when (args[i]){
            "-alg" -> alg = args[i+1]
            "-mode" -> mode = args[i+1]
            "-key" -> key = args[i+1].toInt()
            "-data" -> data = args[i+1]
            "-in" -> data = args[i+1]
            "-out" -> outputFile = args[i+1]
        }
    }
    when (alg) {
        "","shift" -> when (mode) {
            "","enc" -> shiftCharEncrypter(data,key,outputFile)
            "dec" -> shiftCharDecrypter(data,key,outputFile)
        }
        "unicode" -> when (mode) {
            "", "enc" -> encrypter(data,key,outputFile)
            "dec" -> decrypter(data,key,outputFile)
        }
    }


}
