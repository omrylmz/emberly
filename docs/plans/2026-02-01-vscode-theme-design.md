# Emberly VS Code Theme Design

## Overview

VS Code color theme extension with three variants (Carbon, Noir, Umbra) matching the existing JetBrains theme. Full UI theming with Ayu Mirage syntax colors and GitHub Dark UI elements.

## Project Structure

```
emberly/
├── jetbrains/          # existing
├── vscode/
│   ├── package.json    # extension manifest
│   ├── themes/
│   │   ├── emberly-carbon.json
│   │   ├── emberly-noir.json
│   │   └── emberly-umbra.json
│   ├── icon.png        # 128x128 marketplace icon
│   ├── README.md       # marketplace description
│   ├── CHANGELOG.md
│   └── LICENSE
└── README.md           # updated root readme
```

## UI Scope (Workbench Colors)

The theme covers all VS Code UI areas:

- **Editor**: Background, foreground, line numbers, cursor, selection, current line highlight, matching brackets, indent guides
- **Sidebar & Activity Bar**: File explorer, search, source control backgrounds, active/inactive states, badges, icons
- **Terminal**: Background matching editor, ANSI colors from Ayu Mirage palette, cursor, selection
- **Tabs & Title Bar**: Active/inactive tab colors, breadcrumbs, title bar background
- **Panels**: Problems, output, debug console, integrated terminal panel
- **Status Bar**: Background, foreground, item hover states, debugging/no-folder states
- **Inputs & Dropdowns**: Search boxes, command palette, quick pick, settings UI
- **Git Decorations**: Modified, untracked, ignored, conflict colors

## Color Mapping

### Background Variants

| Variant | Editor BG | Sidebar BG | Terminal BG |
|---------|-----------|------------|-------------|
| Carbon  | `#22272e` | `#1e2228`  | `#1e2228`   |
| Noir    | `#0d1117` | `#090c10`  | `#090c10`   |
| Umbra   | `#1e1e1e` | `#1e1e1e`  | `#1e1e1e`   |

### Syntax Colors (Ayu Mirage - shared across all variants)

| Token        | Color     | Used for                 |
|--------------|-----------|--------------------------|
| Orange       | `#f69d50` | Functions, methods       |
| Blue         | `#539bf5` | Variables, parameters    |
| Cyan         | `#39c5cf` | Constants, numbers       |
| Green        | `#57ab5a` | Strings                  |
| Purple       | `#b083f0` | Keywords                 |
| Red          | `#f47067` | Errors, invalid          |
| Gray         | `#636e7b` | Comments                 |
| Light purple | `#dcbdfb` | Types, classes           |

### UI Accent Colors (GitHub Dark)

- Selection: `#274467`
- Link/accent: `#6cb6ff`
- Error: `#f47067`
- Warning: `#f69d50`
- Success: `#57ab5a`

## Token Scopes

| Color                  | TextMate Scopes                                              |
|------------------------|--------------------------------------------------------------|
| Orange `#f69d50`       | `entity.name.function`, `support.function`, `meta.function-call` |
| Blue `#539bf5`         | `variable`, `variable.parameter`, `variable.other`           |
| Cyan `#39c5cf`         | `constant`, `constant.numeric`, `constant.language`          |
| Green `#57ab5a`        | `string`, `string.quoted`                                    |
| Purple `#b083f0`       | `keyword`, `storage.type`, `storage.modifier`                |
| Light purple `#dcbdfb` | `entity.name.type`, `entity.name.class`, `support.type`      |
| Gray `#636e7b`         | `comment`, `punctuation.definition.comment`                  |
| Red `#f47067`          | `invalid`, `invalid.illegal`                                 |

## Publishing Setup

### One-time Setup

1. Create Microsoft account (or use existing)
2. Create Azure DevOps organization at https://dev.azure.com
3. Generate Personal Access Token (PAT) with "Marketplace (publish)" scope
4. Create publisher via `vsce create-publisher <name>`

### Package & Publish Workflow

```bash
cd vscode/
npm install -g @vscode/vsce    # VS Code Extension CLI
vsce package                    # Creates emberly-x.x.x.vsix
vsce publish                    # Publishes to marketplace
```

### package.json Key Fields

```json
{
  "name": "emberly",
  "displayName": "Emberly",
  "publisher": "<your-publisher-id>",
  "version": "1.0.0",
  "engines": { "vscode": "^1.60.0" },
  "categories": ["Themes"],
  "contributes": {
    "themes": [
      { "label": "Emberly Carbon", "uiTheme": "vs-dark", "path": "./themes/emberly-carbon.json" },
      { "label": "Emberly Noir", "uiTheme": "vs-dark", "path": "./themes/emberly-noir.json" },
      { "label": "Emberly Umbra", "uiTheme": "vs-dark", "path": "./themes/emberly-umbra.json" }
    ]
  }
}
```

## Implementation Steps

1. **Create directory structure** - `vscode/` folder with themes subfolder
2. **Create package.json** - Extension manifest with all three variants
3. **Create theme files** - One JSON per variant (emberly-carbon.json, emberly-noir.json, emberly-umbra.json)
4. **Extract colors from JetBrains XML** - Parse existing theme files to ensure exact match
5. **Add marketplace assets** - icon.png (128x128), README.md with screenshots, CHANGELOG.md
6. **Test locally** - Open VS Code, press F5 to launch Extension Development Host
7. **Update root README** - Add VS Code installation instructions
8. **Document publishing** - Include steps for publisher setup

## Distribution

- **Primary**: VS Code Marketplace (official, easy install)
- **Location**: Same repository as JetBrains theme (`vscode/` folder alongside `jetbrains/`)
