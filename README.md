# AnKeyboard - Smart Multilingual Keyboard

AnKeyboard is a modern, minimalist smart keyboard for Android with intelligent word learning, real-time translation, multi-language support, and Material Design 3 aesthetics.

## 🌟 Key Features

### Core Keyboard Features
- **Smart Learning**: Learns from your typing habits and predicts words
- **Autocorrect**: Intelligent auto-correction with visual suggestions  
- **Word Suggestions**: optionally hide the candidate bar or disable autocorrect in settings
- **Emoji Picker**: Complete emoji collection with quick access (50+ emojis)
- **Text Editing**: Full editing toolbar with cut, copy, paste, select all
- **Gesture Typing**: 
  - Swipe left: Delete word
  - Swipe right: Add space
  - Swipe down: Hide keyboard
  - Swipe up: Show emoji picker

### Translation Features
- **Google Translate Integration**: Real-time text translation using MyMemory API
- **7 Languages Supported**:
  - Indonesian (Bahasa Indonesia)
  - English
  - Spanish (Español)
  - French (Français)
  - German (Deutsch)
  - Chinese (中文)
  - Japanese (日本語)

### UI/UX Features
- **Modern Design**: Material Design 3 with clean, minimalist interface
- **Dark Mode**: Full dark theme support with auto-detection
- **Responsive Layout**: Optimized for all screen sizes
- **Smooth Animations**: Polish and feedback with Material transitions

### Personalization
- **Multi-Language UI**: Select your preferred interface language
- **Theme Selection**: Light, Dark, or Auto (system) theme
- **Sound & Vibration**: Toggle keyboard feedback options
- **Advanced Settings**: Customize learning and autocorrect behavior

## 📲 Installation & Setup

### Prerequisites
- Android 5.0 (API 21) or higher
- 50MB free storage space

### Installation Steps

1. **Download & Install**
   - Download the APK or clone the repository
   - Install the app on your Android device

2. **Enable Keyboard**
   - Open Settings → Language & input → Virtual Keyboard
   - Search for "AnKeyboard"
   - Toggle the enable switch

3. **Set as Default**
   - Open AnKeyboard app
   - Click "Select AnKeyboard" button
   - Choose AnKeyboard from the keyboard picker

4. **Configure Settings**
   - Long-press any text field and select "AnKeyboard"
   - Or open the AnKeyboard app and adjust settings in "Settings" tab

## 🔧 Configuration

### Language Settings
Open the AnKeyboard app and navigate to Settings to:
- Change UI language (7 languages supported)
- Select keyboard language
- Enable/disable translation feature
- Choose translation target language

### Theme Preferences
- **Light Mode**: Clean white interface (default)
- **Dark Mode**: Dark background with light text
- **Auto Mode**: Follows system settings

### Keyboard Behavior
- Enable/disable sound feedback
- Enable/disable vibration feedback
- Control word learning (Learning)
- Enable/disable the candidate suggestion bar or autocorrect independently
- Add special characters quick‑access via the “?123” key
- Clipboard history support – pick from recent copies when pasting
- Adjust translation behavior

## 🎯 Advanced Features

### Word Learning System
- Learns from every word you type
- Maintains frequency counts for smarter predictions
- Shows top suggestions in real-time
- Auto-suggests based on typing patterns

### Translation
- Powered by MyMemory Translate API (free, no API key needed)
- Translates as you type (when enabled)
- Supports all UI languages for translation
- Asynchronous translation to avoid latency

### Gesture Recognition
- **Left Swipe**: Delete entire word (50 characters max)
- **Right Swipe**: Add space character
- **Down Swipe**: Hide keyboard
- **Up Swipe**: Show emoji picker

## 📱 Screenshots & Usage

### Main Activity
- Setup buttons for easy first-time configuration
- Test input field to try keyboard features
- Language selector (4-language quick toggle)
- Theme toggle (Light/Dark/Auto)
- Translation settings panel

### Keyboard View
- Clean and minimal key layout
- Real-time word suggestions (toggleable)
- Candidate bar with autocorrect suggestions
- `?123` key to open special characters dialog
- Built‑in clipboard history shown when pasting
- Full QWERTY layout support

## 🔐 Privacy & Security

- **No Cloud Sync**: All data stored locally
- **No Collection**: User typing is never sent to servers
- **Translation Only**: Only text sent for translation (when enabled)
- **Open Source**: LGPL-3.0 licensed code
- **No Tracking**: No analytics or tracking code

## 🛠️ Development

### Technologies Used
- Android SDK 34
- Jetpack (AppCompat, Preferences, ConstraintLayout)
- Material Design 3
- OkHttp 4 for networking
- Retrofit 2 for API calls
- Gson for JSON parsing

### Project Structure
```
AnKeyboard/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/ankeyboard/app/
│   │   │   │   ├── MainActivity.java (Setup & Settings)
│   │   │   │   ├── AnKeyboardService.java (Core Keyboard)
│   │   │   │   ├── SettingsActivity.java (Advanced Settings)
│   │   │   │   ├── LanguageManager.java (Language & Theme)
│   │   │   │   ├── TranslateManager.java (Translation API)
│   │   │   │   └── LearningDictionary.java (Word Learning)
│   │   │   ├── res/
│   │   │   │   ├── layout/ (UI Layouts)
│   │   │   │   ├── drawable/ (Icons & Shapes)
│   │   │   │   ├── values/ (Strings, Colors, Arrays)
│   │   │   │   ├── values-xx/ (Multilingual strings)
│   │   │   │   └── xml/ (Keyboard layouts & preferences)
│   │   │   └── AndroidManifest.xml
│   │   └── build.gradle
│   └── settings.gradle
├── build.gradle
└── README.md
```

### Building from Source

```bash
# Clone the repository
git clone https://github.com/AnerysRynz/AnKeyboard.git
cd AnKeyboard

# Build the project
gradle build

# Install on device
gradle installDebug
```

## 🐛 Troubleshooting

### Debug screen / issue reporter
A hidden **DebugActivity** is available for the app; it allows you to type a title
and description and submit it directly to the project's issue tracker via a
webhook.  The mobile client never holds any GitHub token – the webhook server
(for which a simple Node/Express example is provided in the repository) takes
care of authenticating with GitHub and creating the issue.

See `server.js` and `WEBHOOK_README.md` for details on how to deploy the webhook
and where to configure the `WEBHOOK_URL` constant in `DebugActivity.java`.


### Keyboard doesn't appear
- Ensure keyboard is enabled in Settings → Language & input → Virtual Keyboard
- Check "Enable AnKeyboard" toggle is ON
- Restart the device

### Translation not working
- Enable translation in AnKeyboard settings
- Check internet connection
- Ensure target language is selected
- MyMemory API should be accessible from your region

### Words not learning
- Enable "Learning" in advanced settings
- Type longer words (minimum 2 characters)
- Words are saved automatically

### App crashes
- Clear app cache: Settings → Apps → AnKeyboard → Storage → Clear Cache
- Update to latest version
- File an issue on GitHub with crash logs

## 📊 API Reference

### TranslateManager
```java
// Translate text to target language
String translated = TranslateManager.translate(text, "es");
```

### LanguageManager
```java
// Get/Set language preferences
LanguageManager manager = new LanguageManager(context);
manager.setUILanguage("id");
manager.setTranslateLanguage("en");
manager.setTheme("dark");
```

### LearningDictionary
```java
// Learn new word
LearningDictionary brain = new LearningDictionary(context);
brain.learnWord("keyboard");

// Get predictions
List<String> suggestions = brain.getPredictions("key");
```

## 📝 License

AnKeyboard is released under the **GNU Lesser General Public License v3.0 (LGPL-3.0)**.

```
Copyright (C) 2026 AnerysRynz

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU Lesser General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
GNU Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public License
along with this program. If not, see <https://www.gnu.org/licenses/>.
```

## 🤝 Contributing

Contributions are welcome! Please:
1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit changes (`git commit -m 'Add AmazingFeature'`)
4. Push to branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📞 Support

For issues, feature requests, or questions:
- Open an issue on GitHub
- Check existing issues for solutions
- For security issues, please email directly

## 🎉 Changelog

### Version 1.0 (Initial Release)
- Modern Material Design 3 UI
- Smart word learning system
- Google Translate integration
- Multi-language support (7 languages)
- Dark mode with auto-detection
- Full text editing features
- Emoji picker with 50+ emojis
- Gesture typing support
- Comprehensive settings panel
- LGPL-3.0 license

## 🚀 Roadmap

- [ ] Cloud sync for learned words
- [ ] More emoji categories
- [ ] Custom dictionary support
- [ ] Gesture customization
- [ ] Keyboard themes
- [ ] Haptic feedback improvements
- [ ] Voice input integration
- [ ] Swipe keyboard layout option

---

**Made with ❤️ by AnerysRynz**

[GitHub](https://github.com/AnerysRynz) | [Issues](https://github.com/AnerysRynz/AnKeyboard/issues)


## Contributing

Contributions are very welcome! Please create an issue or pull request.

## Developer

- **AnerysRynz** - Main Developer

---

Developed with ❤️ using Android Studio