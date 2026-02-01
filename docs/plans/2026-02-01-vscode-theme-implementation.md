# Emberly VS Code Theme Implementation Plan

> **For Claude:** REQUIRED SUB-SKILL: Use superpowers:executing-plans to implement this plan task-by-task.

**Goal:** Create a VS Code color theme extension with three variants (Carbon, Noir, Umbra) matching the JetBrains theme exactly.

**Architecture:** Single VS Code extension with three theme JSON files, each containing workbench colors (UI) and tokenColors (syntax). Colors are extracted from existing JetBrains XML files.

**Tech Stack:** VS Code Extension API, JSON theme format, vsce CLI for publishing

---

## Color Reference

### Background Variants (from JetBrains XML)

| Variant | Editor BG   | Sidebar BG  | Current Line | Selection   | Caret     |
|---------|-------------|-------------|--------------|-------------|-----------|
| Carbon  | `#22272e`   | `#1e2228`   | `#2d333b`    | `#274467`   | `#6cb6ff` |
| Noir    | `#1e1e1e`   | `#1e1e1e`   | `#303030`    | `#245187`   | `#79c0ff` |
| Umbra   | `#0d1117`   | `#090c10`   | `#161b22`    | `#173456`   | `#79c0ff` |

### Syntax Colors (Ayu Mirage - shared)

| Token        | Color     |
|--------------|-----------|
| Function     | `#ffd580` |
| Variable     | `#cbccc6` |
| Constant     | `#dfbfff` |
| Number       | `#6cb6ff` |
| String       | `#57ab5a` |
| Keyword      | `#b083f0` |
| Type         | `#dcbdfb` |
| Comment      | `#636e7b` |
| Error        | `#f47067` |
| Annotation   | `#f69d50` |

### Terminal ANSI Colors (from JetBrains XML)

| Color          | Normal    | Bright    |
|----------------|-----------|-----------|
| Black          | `#545d68` | `#636e7b` |
| Red            | `#f47067` | `#ff938a` |
| Green          | `#57ab5a` | `#6bc46d` |
| Yellow         | `#c69026` | `#daaa3f` |
| Blue           | `#539bf5` | `#6cb6ff` |
| Magenta        | `#b083f0` | `#dcbdfb` |
| Cyan           | `#39c5cf` | `#56d4dd` |
| White          | `#909dab` | `#cdd9e5` |

---

## Task 1: Create Directory Structure

**Files:**
- Create: `vscode/`
- Create: `vscode/themes/`

**Step 1: Create directories**

```bash
cd /Users/omeryilmaz/Workspace/emberly/.worktrees/vscode-theme
mkdir -p vscode/themes
```

**Step 2: Verify structure**

```bash
ls -la vscode/
```

Expected: `themes/` directory exists

**Step 3: Commit**

```bash
git add vscode/
git commit -m "chore: create vscode extension directory structure"
```

---

## Task 2: Create package.json

**Files:**
- Create: `vscode/package.json`

**Step 1: Create package.json**

```json
{
  "name": "emberly",
  "displayName": "Emberly",
  "description": "A dark theme with Ayu Mirage syntax colors and GitHub Dark UI. Three variants: Carbon (balanced), Noir (medium), Umbra (darkest).",
  "version": "1.0.0",
  "publisher": "emberly",
  "license": "MIT",
  "repository": {
    "type": "git",
    "url": "https://github.com/omeryilmaz/emberly"
  },
  "engines": {
    "vscode": "^1.60.0"
  },
  "categories": [
    "Themes"
  ],
  "keywords": [
    "theme",
    "dark",
    "ayu",
    "github",
    "syntax"
  ],
  "icon": "icon.png",
  "contributes": {
    "themes": [
      {
        "label": "Emberly Carbon",
        "uiTheme": "vs-dark",
        "path": "./themes/emberly-carbon.json"
      },
      {
        "label": "Emberly Noir",
        "uiTheme": "vs-dark",
        "path": "./themes/emberly-noir.json"
      },
      {
        "label": "Emberly Umbra",
        "uiTheme": "vs-dark",
        "path": "./themes/emberly-umbra.json"
      }
    ]
  }
}
```

**Step 2: Verify JSON is valid**

```bash
cd vscode && cat package.json | python3 -m json.tool > /dev/null && echo "Valid JSON"
```

Expected: "Valid JSON"

**Step 3: Commit**

```bash
git add vscode/package.json
git commit -m "feat: add VS Code extension manifest"
```

---

## Task 3: Create Emberly Carbon Theme

**Files:**
- Create: `vscode/themes/emberly-carbon.json`

**Step 1: Create Carbon theme file**

Create `vscode/themes/emberly-carbon.json` with the following content (complete theme):

```json
{
  "name": "Emberly Carbon",
  "type": "dark",
  "colors": {
    "editor.background": "#22272e",
    "editor.foreground": "#adbac7",
    "editor.lineHighlightBackground": "#2d333b",
    "editor.selectionBackground": "#274467",
    "editorCursor.foreground": "#6cb6ff",
    "editorLineNumber.foreground": "#636e7b",
    "editorLineNumber.activeForeground": "#adbac7",
    "editorIndentGuide.background1": "#373e47",
    "editorIndentGuide.activeBackground1": "#545d68",
    "editorWhitespace.foreground": "#373e47",
    "editorBracketMatch.background": "#274467",
    "editorBracketMatch.border": "#6cb6ff",

    "activityBar.background": "#1e2228",
    "activityBar.foreground": "#adbac7",
    "activityBar.inactiveForeground": "#636e7b",
    "activityBarBadge.background": "#539bf5",
    "activityBarBadge.foreground": "#ffffff",

    "sideBar.background": "#1e2228",
    "sideBar.foreground": "#adbac7",
    "sideBarTitle.foreground": "#adbac7",
    "sideBarSectionHeader.background": "#22272e",
    "sideBarSectionHeader.foreground": "#adbac7",

    "list.activeSelectionBackground": "#274467",
    "list.activeSelectionForeground": "#adbac7",
    "list.inactiveSelectionBackground": "#2d333b",
    "list.hoverBackground": "#2d333b",
    "list.focusBackground": "#274467",

    "tab.activeBackground": "#22272e",
    "tab.activeForeground": "#adbac7",
    "tab.inactiveBackground": "#1e2228",
    "tab.inactiveForeground": "#636e7b",
    "tab.border": "#1e2228",
    "editorGroupHeader.tabsBackground": "#1e2228",

    "titleBar.activeBackground": "#1e2228",
    "titleBar.activeForeground": "#adbac7",
    "titleBar.inactiveBackground": "#1e2228",
    "titleBar.inactiveForeground": "#636e7b",

    "statusBar.background": "#1e2228",
    "statusBar.foreground": "#adbac7",
    "statusBar.debuggingBackground": "#f47067",
    "statusBar.debuggingForeground": "#ffffff",
    "statusBar.noFolderBackground": "#1e2228",
    "statusBarItem.hoverBackground": "#2d333b",
    "statusBarItem.remoteBackground": "#539bf5",
    "statusBarItem.remoteForeground": "#ffffff",

    "panel.background": "#1e2228",
    "panel.border": "#373e47",
    "panelTitle.activeBorder": "#539bf5",
    "panelTitle.activeForeground": "#adbac7",
    "panelTitle.inactiveForeground": "#636e7b",

    "terminal.background": "#1e2228",
    "terminal.foreground": "#adbac7",
    "terminal.ansiBlack": "#545d68",
    "terminal.ansiRed": "#f47067",
    "terminal.ansiGreen": "#57ab5a",
    "terminal.ansiYellow": "#c69026",
    "terminal.ansiBlue": "#539bf5",
    "terminal.ansiMagenta": "#b083f0",
    "terminal.ansiCyan": "#39c5cf",
    "terminal.ansiWhite": "#909dab",
    "terminal.ansiBrightBlack": "#636e7b",
    "terminal.ansiBrightRed": "#ff938a",
    "terminal.ansiBrightGreen": "#6bc46d",
    "terminal.ansiBrightYellow": "#daaa3f",
    "terminal.ansiBrightBlue": "#6cb6ff",
    "terminal.ansiBrightMagenta": "#dcbdfb",
    "terminal.ansiBrightCyan": "#56d4dd",
    "terminal.ansiBrightWhite": "#cdd9e5",
    "terminalCursor.foreground": "#6cb6ff",

    "input.background": "#2d333b",
    "input.foreground": "#adbac7",
    "input.border": "#373e47",
    "input.placeholderForeground": "#636e7b",
    "inputOption.activeBorder": "#539bf5",
    "inputValidation.errorBackground": "#5d2927",
    "inputValidation.errorBorder": "#f47067",
    "inputValidation.warningBackground": "#5c4f17",
    "inputValidation.warningBorder": "#c69026",

    "dropdown.background": "#2d333b",
    "dropdown.foreground": "#adbac7",
    "dropdown.border": "#373e47",

    "button.background": "#539bf5",
    "button.foreground": "#ffffff",
    "button.hoverBackground": "#6cb6ff",
    "button.secondaryBackground": "#373e47",
    "button.secondaryForeground": "#adbac7",

    "scrollbar.shadow": "#00000033",
    "scrollbarSlider.background": "#373e4780",
    "scrollbarSlider.hoverBackground": "#545d6880",
    "scrollbarSlider.activeBackground": "#636e7b80",

    "badge.background": "#539bf5",
    "badge.foreground": "#ffffff",

    "progressBar.background": "#539bf5",

    "editorWidget.background": "#2d333b",
    "editorWidget.border": "#373e47",
    "editorSuggestWidget.background": "#2d333b",
    "editorSuggestWidget.border": "#373e47",
    "editorSuggestWidget.selectedBackground": "#274467",

    "peekView.border": "#539bf5",
    "peekViewEditor.background": "#22272e",
    "peekViewResult.background": "#1e2228",
    "peekViewTitle.background": "#2d333b",

    "gitDecoration.addedResourceForeground": "#57ab5a",
    "gitDecoration.modifiedResourceForeground": "#539bf5",
    "gitDecoration.deletedResourceForeground": "#f47067",
    "gitDecoration.untrackedResourceForeground": "#57ab5a",
    "gitDecoration.ignoredResourceForeground": "#545d68",
    "gitDecoration.conflictingResourceForeground": "#c69026",

    "editorError.foreground": "#f47067",
    "editorWarning.foreground": "#c69026",
    "editorInfo.foreground": "#539bf5",

    "focusBorder": "#539bf5",
    "foreground": "#adbac7",
    "selection.background": "#274467",
    "widget.shadow": "#00000033"
  },
  "tokenColors": [
    {
      "name": "Comment",
      "scope": ["comment", "punctuation.definition.comment"],
      "settings": {
        "foreground": "#636e7b",
        "fontStyle": "italic"
      }
    },
    {
      "name": "String",
      "scope": ["string", "string.quoted"],
      "settings": {
        "foreground": "#96d0ff"
      }
    },
    {
      "name": "Number",
      "scope": ["constant.numeric"],
      "settings": {
        "foreground": "#6cb6ff"
      }
    },
    {
      "name": "Constant",
      "scope": ["constant", "constant.language"],
      "settings": {
        "foreground": "#6cb6ff"
      }
    },
    {
      "name": "Keyword",
      "scope": ["keyword", "storage.type", "storage.modifier"],
      "settings": {
        "foreground": "#f47067"
      }
    },
    {
      "name": "Function",
      "scope": ["entity.name.function", "support.function", "meta.function-call"],
      "settings": {
        "foreground": "#dcbdfb"
      }
    },
    {
      "name": "Class",
      "scope": ["entity.name.type", "entity.name.class", "support.type", "support.class"],
      "settings": {
        "foreground": "#f69d50"
      }
    },
    {
      "name": "Variable",
      "scope": ["variable", "variable.other"],
      "settings": {
        "foreground": "#adbac7"
      }
    },
    {
      "name": "Parameter",
      "scope": ["variable.parameter"],
      "settings": {
        "foreground": "#f69d50"
      }
    },
    {
      "name": "Property",
      "scope": ["variable.other.property", "variable.other.object.property"],
      "settings": {
        "foreground": "#adbac7"
      }
    },
    {
      "name": "Operator",
      "scope": ["keyword.operator"],
      "settings": {
        "foreground": "#f47067"
      }
    },
    {
      "name": "Punctuation",
      "scope": ["punctuation"],
      "settings": {
        "foreground": "#adbac7"
      }
    },
    {
      "name": "Annotation",
      "scope": ["storage.type.annotation", "punctuation.definition.annotation"],
      "settings": {
        "foreground": "#dcbdfb"
      }
    },
    {
      "name": "Decorator",
      "scope": ["meta.decorator", "punctuation.decorator"],
      "settings": {
        "foreground": "#dcbdfb"
      }
    },
    {
      "name": "Tag",
      "scope": ["entity.name.tag"],
      "settings": {
        "foreground": "#7ee787"
      }
    },
    {
      "name": "Tag Attribute",
      "scope": ["entity.other.attribute-name"],
      "settings": {
        "foreground": "#79c0ff"
      }
    },
    {
      "name": "Invalid",
      "scope": ["invalid", "invalid.illegal"],
      "settings": {
        "foreground": "#f47067"
      }
    },
    {
      "name": "Markup Heading",
      "scope": ["markup.heading", "entity.name.section"],
      "settings": {
        "foreground": "#539bf5",
        "fontStyle": "bold"
      }
    },
    {
      "name": "Markup Bold",
      "scope": ["markup.bold"],
      "settings": {
        "fontStyle": "bold"
      }
    },
    {
      "name": "Markup Italic",
      "scope": ["markup.italic"],
      "settings": {
        "fontStyle": "italic"
      }
    },
    {
      "name": "Markup Link",
      "scope": ["markup.underline.link"],
      "settings": {
        "foreground": "#6cb6ff"
      }
    },
    {
      "name": "Markup Code",
      "scope": ["markup.inline.raw", "markup.fenced_code"],
      "settings": {
        "foreground": "#96d0ff"
      }
    },
    {
      "name": "CSS Selector",
      "scope": ["entity.other.attribute-name.class.css", "entity.other.attribute-name.id.css"],
      "settings": {
        "foreground": "#7ee787"
      }
    },
    {
      "name": "CSS Property",
      "scope": ["support.type.property-name.css"],
      "settings": {
        "foreground": "#79c0ff"
      }
    },
    {
      "name": "CSS Value",
      "scope": ["support.constant.property-value.css"],
      "settings": {
        "foreground": "#a5d6ff"
      }
    },
    {
      "name": "JSON Key",
      "scope": ["support.type.property-name.json"],
      "settings": {
        "foreground": "#7ee787"
      }
    },
    {
      "name": "YAML Key",
      "scope": ["entity.name.tag.yaml"],
      "settings": {
        "foreground": "#7ee787"
      }
    },
    {
      "name": "Regex",
      "scope": ["string.regexp"],
      "settings": {
        "foreground": "#a5d6ff"
      }
    },
    {
      "name": "Escape Character",
      "scope": ["constant.character.escape"],
      "settings": {
        "foreground": "#79c0ff"
      }
    }
  ]
}
```

**Step 2: Verify JSON is valid**

```bash
cat vscode/themes/emberly-carbon.json | python3 -m json.tool > /dev/null && echo "Valid JSON"
```

Expected: "Valid JSON"

**Step 3: Commit**

```bash
git add vscode/themes/emberly-carbon.json
git commit -m "feat: add Emberly Carbon theme"
```

---

## Task 4: Create Emberly Noir Theme

**Files:**
- Create: `vscode/themes/emberly-noir.json`

**Step 1: Create Noir theme file**

Copy Carbon theme and modify these colors:
- `editor.background`: `#1e1e1e`
- `editor.lineHighlightBackground`: `#303030`
- `editor.selectionBackground`: `#245187`
- `editorCursor.foreground`: `#79c0ff`
- `activityBar.background`: `#1e1e1e`
- `sideBar.background`: `#1e1e1e`
- `sideBarSectionHeader.background`: `#1e1e1e`
- `tab.activeBackground`: `#1e1e1e`
- `tab.inactiveBackground`: `#1e1e1e`
- `tab.border`: `#1e1e1e`
- `editorGroupHeader.tabsBackground`: `#1e1e1e`
- `titleBar.activeBackground`: `#1e1e1e`
- `titleBar.inactiveBackground`: `#1e1e1e`
- `statusBar.background`: `#1e1e1e`
- `statusBar.noFolderBackground`: `#1e1e1e`
- `panel.background`: `#1e1e1e`
- `terminal.background`: `#1e1e1e`
- `peekViewEditor.background`: `#1e1e1e`
- `peekViewResult.background`: `#1e1e1e`
- `terminalCursor.foreground`: `#79c0ff`
- `list.activeSelectionBackground`: `#245187`
- `list.inactiveSelectionBackground`: `#303030`
- `list.hoverBackground`: `#303030`
- `list.focusBackground`: `#245187`
- `input.background`: `#303030`
- `dropdown.background`: `#303030`
- `editorWidget.background`: `#303030`
- `editorSuggestWidget.background`: `#303030`
- `editorSuggestWidget.selectedBackground`: `#245187`
- `peekViewTitle.background`: `#303030`
- `editorIndentGuide.background1`: `#303030`
- `editorIndentGuide.activeBackground1`: `#4d4d4d`
- `editorWhitespace.foreground`: `#303030`
- `panel.border`: `#303030`
- `input.border`: `#303030`
- `dropdown.border`: `#303030`
- `editorWidget.border`: `#303030`
- `editorSuggestWidget.border`: `#303030`
- `button.secondaryBackground`: `#303030`
- `scrollbarSlider.background`: `#30303080`
- `scrollbarSlider.hoverBackground`: `#4d4d4d80`
- `scrollbarSlider.activeBackground`: `#66666680`
- `statusBarItem.hoverBackground`: `#303030`
- `selection.background`: `#245187`
- `editorBracketMatch.background`: `#245187`

**Step 2: Verify JSON is valid**

```bash
cat vscode/themes/emberly-noir.json | python3 -m json.tool > /dev/null && echo "Valid JSON"
```

**Step 3: Commit**

```bash
git add vscode/themes/emberly-noir.json
git commit -m "feat: add Emberly Noir theme"
```

---

## Task 5: Create Emberly Umbra Theme

**Files:**
- Create: `vscode/themes/emberly-umbra.json`

**Step 1: Create Umbra theme file**

Copy Carbon theme and modify these colors:
- `editor.background`: `#0d1117`
- `editor.lineHighlightBackground`: `#161b22`
- `editor.selectionBackground`: `#173456`
- `editorCursor.foreground`: `#79c0ff`
- `activityBar.background`: `#090c10`
- `sideBar.background`: `#090c10`
- `sideBarSectionHeader.background`: `#0d1117`
- `tab.activeBackground`: `#0d1117`
- `tab.inactiveBackground`: `#090c10`
- `tab.border`: `#090c10`
- `editorGroupHeader.tabsBackground`: `#090c10`
- `titleBar.activeBackground`: `#090c10`
- `titleBar.inactiveBackground`: `#090c10`
- `statusBar.background`: `#090c10`
- `statusBar.noFolderBackground`: `#090c10`
- `panel.background`: `#090c10`
- `terminal.background`: `#090c10`
- `peekViewEditor.background`: `#0d1117`
- `peekViewResult.background`: `#090c10`
- `terminalCursor.foreground`: `#79c0ff`
- `list.activeSelectionBackground`: `#173456`
- `list.inactiveSelectionBackground`: `#161b22`
- `list.hoverBackground`: `#161b22`
- `list.focusBackground`: `#173456`
- `input.background`: `#161b22`
- `dropdown.background`: `#161b22`
- `editorWidget.background`: `#161b22`
- `editorSuggestWidget.background`: `#161b22`
- `editorSuggestWidget.selectedBackground`: `#173456`
- `peekViewTitle.background`: `#161b22`
- `editorIndentGuide.background1`: `#21262d`
- `editorIndentGuide.activeBackground1`: `#30363d`
- `editorWhitespace.foreground`: `#21262d`
- `panel.border`: `#21262d`
- `input.border`: `#21262d`
- `dropdown.border`: `#21262d`
- `editorWidget.border`: `#21262d`
- `editorSuggestWidget.border`: `#21262d`
- `button.secondaryBackground`: `#21262d`
- `scrollbarSlider.background`: `#21262d80`
- `scrollbarSlider.hoverBackground`: `#30363d80`
- `scrollbarSlider.activeBackground`: `#484f5880`
- `statusBarItem.hoverBackground`: `#161b22`
- `selection.background`: `#173456`
- `editorBracketMatch.background`: `#173456`

**Step 2: Verify JSON is valid**

```bash
cat vscode/themes/emberly-umbra.json | python3 -m json.tool > /dev/null && echo "Valid JSON"
```

**Step 3: Commit**

```bash
git add vscode/themes/emberly-umbra.json
git commit -m "feat: add Emberly Umbra theme"
```

---

## Task 6: Add Marketplace Assets

**Files:**
- Create: `vscode/README.md`
- Create: `vscode/CHANGELOG.md`
- Copy: `vscode/LICENSE`
- Create: `vscode/icon.png` (manual step - copy from JetBrains)

**Step 1: Create README.md**

```markdown
# Emberly

A dark theme with Ayu Mirage syntax colors and GitHub Dark UI elements.

## Variants

- **Emberly Carbon** - Balanced mid-tone (GitHub Dark Dimmed style)
- **Emberly Noir** - Medium gray, VS Code native feel
- **Emberly Umbra** - Darkest variant (GitHub Dark Default style)

## Installation

1. Open **Extensions** sidebar in VS Code (`Ctrl+Shift+X` / `Cmd+Shift+X`)
2. Search for `Emberly`
3. Click **Install**
4. Open **Command Palette** (`Ctrl+Shift+P` / `Cmd+Shift+P`)
5. Select **Preferences: Color Theme**
6. Choose your preferred Emberly variant

## Screenshots

### Carbon
![Emberly Carbon](https://raw.githubusercontent.com/omeryilmaz/emberly/main/screenshots/vscode-carbon.png)

### Noir
![Emberly Noir](https://raw.githubusercontent.com/omeryilmaz/emberly/main/screenshots/vscode-noir.png)

### Umbra
![Emberly Umbra](https://raw.githubusercontent.com/omeryilmaz/emberly/main/screenshots/vscode-umbra.png)

## Color Palette

| Element      | Color     |
|--------------|-----------|
| Functions    | `#dcbdfb` |
| Keywords     | `#f47067` |
| Strings      | `#96d0ff` |
| Numbers      | `#6cb6ff` |
| Types        | `#f69d50` |
| Comments     | `#636e7b` |

## Also Available

- [JetBrains IDEs](https://plugins.jetbrains.com/plugin/XXX-emberly)

## License

MIT
```

**Step 2: Create CHANGELOG.md**

```markdown
# Changelog

## 1.0.0 - 2026-02-01

### Added
- Initial release
- Three theme variants: Carbon, Noir, Umbra
- Full workbench theming (editor, sidebar, terminal, panels)
- Syntax highlighting for all major languages
- Terminal ANSI color support
- Git decoration colors
```

**Step 3: Copy LICENSE**

```bash
cp LICENSE vscode/LICENSE
```

**Step 4: Create icon placeholder**

Note: Create a 128x128 PNG icon. For now, create a placeholder:

```bash
# Manual step: Copy icon from JetBrains plugin or create new one
# Icon should be 128x128 PNG
```

**Step 5: Commit**

```bash
git add vscode/README.md vscode/CHANGELOG.md vscode/LICENSE
git commit -m "docs: add marketplace assets"
```

---

## Task 7: Test Locally

**Step 1: Open VS Code in extension directory**

```bash
code vscode/
```

**Step 2: Launch Extension Development Host**

1. Press `F5` in VS Code
2. In new window, open Command Palette (`Ctrl+Shift+P`)
3. Select "Preferences: Color Theme"
4. Choose "Emberly Carbon"

**Step 3: Verify each variant**

- Switch between Carbon, Noir, Umbra
- Check editor background colors match
- Check terminal opens with correct colors
- Check sidebar, activity bar, status bar
- Open a code file, verify syntax highlighting

**Step 4: Note any issues**

Document any color mismatches for fixing.

---

## Task 8: Update Root README

**Files:**
- Modify: `README.md`

**Step 1: Add VS Code section**

Add to root README.md after JetBrains section:

```markdown
## VS Code

### Installation

1. Open Extensions sidebar (`Ctrl+Shift+X`)
2. Search for "Emberly"
3. Click Install
4. Select theme: `Preferences: Color Theme` → Emberly Carbon/Noir/Umbra

### Manual Installation

Download `.vsix` from [Releases](https://github.com/omeryilmaz/emberly/releases), then:
```bash
code --install-extension emberly-1.0.0.vsix
```
```

**Step 2: Commit**

```bash
git add README.md
git commit -m "docs: add VS Code installation instructions"
```

---

## Task 9: Final Verification

**Step 1: Verify all files exist**

```bash
ls -la vscode/
ls -la vscode/themes/
```

Expected structure:
```
vscode/
├── package.json
├── themes/
│   ├── emberly-carbon.json
│   ├── emberly-noir.json
│   └── emberly-umbra.json
├── icon.png
├── README.md
├── CHANGELOG.md
└── LICENSE
```

**Step 2: Verify themes load**

```bash
cd vscode && code . && echo "Press F5 to test"
```

**Step 3: Package extension**

```bash
npm install -g @vscode/vsce
cd vscode
vsce package
```

Expected: `emberly-1.0.0.vsix` created

---

## Publishing (Manual - After Testing)

Once tested and ready:

1. Create Azure DevOps account at https://dev.azure.com
2. Generate Personal Access Token with Marketplace scope
3. Create publisher: `vsce create-publisher emberly`
4. Publish: `vsce publish`
