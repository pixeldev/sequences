package es.revengenetwork.template.translation;

import com.google.common.collect.ImmutableMap;
import es.revengenetwork.fenix.paper.command.translate.ConfiguredTranslationProvider;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.configurate.objectmapping.ConfigSerializable;

/**
 * This class contains the translations of custom {@link es.revengenetwork.command.part.CommandPart}s.
 *
 * @since 0.0.1
 */
@ConfigSerializable
@SuppressWarnings("ALL")
public class CommandLanguage implements ConfiguredTranslationProvider {
  private Map<String, String> translations = ImmutableMap.<String, String>builder()
    .put("invalid.something", "<red>¡El argumento '<param:0>' no es válido!")
    .build();

  @Override
  public @Nullable String translate(final @NotNull String key) {
    return this.translations.get(key);
  }
}
