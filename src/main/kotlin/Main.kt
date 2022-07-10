import com.appmattus.crypto.Algorithm
import java.awt.Image
import java.io.File
import java.util.*



fun main(args: Array<String>) {
    val bytes = File("src/main/resources/img.jpeg").readBytes()
    val inputString2 = Base64.getEncoder().encodeToString(bytes)

    val bufferedReader = File("src/base64.txt").bufferedReader()
    val inputString = bufferedReader.use { it.readText() }
    if (inputString != inputString2)
        print("di=========")
    val stringByteArray = inputString.encodeToByteArray()
    val digest = Algorithm.XXHash64(0).createDigest()
    val hash = digest.digest(stringByteArray)
    hash.forEach {

        print(String.format("%02X", it))

    }
    print("done")
}