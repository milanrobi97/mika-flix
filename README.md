# Mika Flix - Android Streaming Aplikacija

## 📱 Opis

Mika Flix je Android aplikacija za streaming filmova bez reklama. Aplikacija omogućava pregledavanje i puštanje filmova sa streamex.net izvora.

## 🎯 Karakteristike

✅ **Bez reklama** - Čist prikaz bez ikakvih smetnji
✅ **Popis filmova** - Dinamički učitani filmovi sa API-ja
✅ **Video player** - ExoPlayer za reproduciranje videa
✅ **Responsivni dizajn** - Radi na svim uređajima
✅ **Kotlin** - Moderan programski jezik

## 🛠️ Tehnička Specifikacija

- **Language**: Kotlin
- **Minimum SDK**: API 24
- **Target SDK**: API 34
- **Package**: com.mika.mfilmovi.mikaflix

## 📋 Zavisnosti

- AndroidX AppCompat 1.6.1
- ExoPlayer 2.19.1
- OkHttp 4.11.0
- Gson 2.10.1
- Picasso 2.8
- Kotlin Coroutines 1.7.1

## 🚀 Kako koristiti

1. **Kloniraj repozitorij**
   ```bash
   git clone https://github.com/milanrobi97/mika-flix.git
   ```

2. **Otvori Android Studio**

3. **File → Open** i odaberi `mika-flix` direktorijum

4. **Čekaj** da se Gradle sinhronizira (~5 minuta)

5. **Run** ili **Shift+F10** da pokeneš aplikaciju

6. **Odaberi emulator ili uređaj**

## 📂 Struktura Projekta

```
mika-flix/
├── app/
│   ├── src/main/
│   │   ├── kotlin/com/mika/mfilmovi/mikaflix/
│   │   │   ├── MainActivity.kt
│   │   │   ├── PlayerActivity.kt
│   │   │   └── ApiService.kt
│   │   ├── res/layout/
│   │   │   ├── activity_main.xml
│   │   │   ├── activity_player.xml
│   │   │   └── movie_item.xml
│   │   ├── res/values/
│   │   │   ├── strings.xml
│   │   │   ├── themes.xml
│   │   │   └── values-night/themes.xml
│   │   └── AndroidManifest.xml
│   └── build.gradle.kts
├── build.gradle.kts
├── settings.gradle.kts
└── README.md
```

## 🔧 Konfiguracija

Za promjenu API URL-a, idi u `app/src/main/kotlin/com/mika/mfilmovi/mikaflix/ApiService.kt`:

```kotlin
.url("https://www.streamex.net/api/movies")
```

## 💡 Napomena

Aplikacija koristi dummy podatke ako API nije dostupan. To omogućava testiranje bez interneta.

## 📥 Download

- 🌐 [GitHub Repository](https://github.com/milanrobi97/mika-flix)
- 📦 [Preuzmi ZIP](https://github.com/milanrobi97/mika-flix/archive/refs/heads/main.zip)

---

**Verzija**: 1.0
**Autor**: Mika Flix Team
**License**: Private
