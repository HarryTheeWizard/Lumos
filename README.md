# Lumos

Dynamic lighting for Minecraft 26.1.2 with Sodium. Held items that emit light now actually illuminate the world around you.

## Features

- Dynamic lighting from held light-emitting items
- Three modes: OFF, FAST, and REALTIME
- Distance-based light falloff
- No mods required beyond Sodium
- Config persists between sessions

## Modes

| Mode | Description |
|------|-------------|
| OFF | Dynamic lighting disabled |
| FAST | Light updates when you move. Lower performance cost. |
| REALTIME | Smooth per-block lightmap injection. Higher quality. |

Change mode by editing `config/lumos.properties` in your Minecraft folder.

## Supported Items

Torch, Soul Torch, Lantern, Soul Lantern, Glowstone, Sea Lantern, Shroomlight, Beacon, End Rod, Blaze Rod, Lava Bucket, Fire Charge, Glowstone Dust, Glow Ink Sac, Glow Berries, Magma Block, Crying Obsidian, Nether Star, Campfire, Soul Campfire, Jack o'Lantern, Sea Pickle, Redstone Torch, Ochre Froglight, Verdant Froglight, Pearlescent Froglight.

## Known Issues

- Low-luminance items (light level 8 and below, e.g. Glow Berries) may show minor lighting artifacts at chunk boundaries. This is a limitation of how Sodium handles chunk rebuilds and will be addressed in a future update.

## Requirements

- Minecraft 26.1.2
- Fabric Loader
- Sodium

## License

MIT
