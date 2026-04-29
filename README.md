# **PPB G Tugas 5: Calculator App**
| Nama         | NRP           |
| :--------: | :------------: |
| Genta Putra Prayoga |5025221040 |

Aplikasi Calculator adalah aplikasi Android sederhana yang memungkinkan pengguna untuk melakukan operasi matematika dasar seperti penambahan, pengurangan, perkalian, dan pembagian. Proyek ini dibangun menggunakan Jetpack Compose dan Kotlin, mendemonstrasikan penggunaan modern Android development.

## Fitur
- Dua kolom input untuk memasukkan angka
- Empat tombol operasi: Add, Sub, Mul, dan Div
- Tampilan hasil menggunakan Toast
- UI yang responsif dengan desain sederhana dan intuitif
- Implementasi menggunakan modern Android development dengan Jetpack Compose

## Tangkapan Layar
[Gambar aplikasi kalkulator]

## Teknologi yang Digunakan
- **Kotlin**: Bahasa pemrograman utama
- **Jetpack Compose**: Framework UI modern untuk Android
- **Android Studio**: IDE pengembangan

## Konsep Utama yang Dipelajari
1. **Fungsi @Composable**: Pembuatan komponen UI dengan Jetpack Compose
2. **State Management**: Pengelolaan state aplikasi dengan remember dan mutableStateOf
3. **Komponen Dasar**: Penggunaan komponen TextField, Button, Text, dan layout seperti Column dan Row
4. **Event Handling**: Implementasi handler onClick untuk tombol operasi
5. **Reactive UI**: Pembaruan UI secara otomatis ketika state berubah
6. **Toast Notification**: Menampilkan hasil operasi menggunakan Toast

## Struktur Proyek
```
app/
├── src/
│   ├── main/
│   │   ├── java/com/example/mycalculator/
│   │   │   ├── MainActivity.kt      # Entry point aplikasi
│   │   │   └── ui/theme/            # Tema aplikasi
│   │   ├── res/
│   │   │   ├── values/
│   │   │   │   └── strings.xml      # String resource
```

## Cara Menjalankan Proyek
1. Clone repositori ini
2. Buka proyek di Android Studio
3. Jalankan aplikasi pada emulator atau perangkat fisik Android

## Implementasi Kunci
```kotlin
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            var num1 by remember {
                mutableStateOf("0")
            }

            var num2 by remember {
                mutableStateOf("0")
            }

            Column {
                TextField(value = num1, onValueChange = {
                    num1 = it;
                })
                TextField(value = num2, onValueChange = {
                    num2 = it;
                })

                Row {
                    Button(onClick = {
                        var result = num1.toInt() + num2.toInt()
                        Toast.makeText(applicationContext,"Result is $result",Toast.LENGTH_SHORT).show()
                    }) {
                        Text(text = "Add")
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    Button(onClick = {
                        var result = num1.toInt() - num2.toInt()
                        Toast.makeText(applicationContext,"Result is $result",Toast.LENGTH_SHORT).show()
                    }) {
                        Text(text = "Sub")
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    Button(onClick = {
                        var result = num1.toInt() * num2.toInt()
                        Toast.makeText(applicationContext,"Result is $result",Toast.LENGTH_SHORT).show()
                    }) {
                        Text(text = "Mul")
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    Button(onClick = {
                        var result = num1.toInt() / num2.toInt()
                        Toast.makeText(applicationContext,"Result is $result",Toast.LENGTH_SHORT).show()
                    }) {
                        Text(text = "Div")
                    }
                }
            }
        }
    }
}
```

## Sumber Belajar
- Jetpack Compose Documentation
- Android Developers - Build Your First Android App in Kotlin
