package es.revengenetwork.template;

import com.google.inject.Provides;
import com.google.inject.Singleton;
import es.revengenetwork.fenix.inject.ProtectedModule;
import es.revengenetwork.fenix.paper.command.CommandModule;
import es.revengenetwork.fenix.paper.command.translate.ConfiguredTranslationProvider;
import es.revengenetwork.fenix.paper.config.ConfigurationContainer;
import es.revengenetwork.fenix.paper.translate.LanguageConfigurationHelper;
import es.revengenetwork.fenix.paper.translate.MessageHandlerModule;
import java.nio.file.Path;
import es.revengenetwork.template.translation.Language;
import org.jetbrains.annotations.NotNull;

public final class MainModule extends ProtectedModule {
  @Override
  public void configure() {
    super.install(new CommandModule());
    super.install(new MessageHandlerModule());
  }

  @Provides
  @Singleton
  public @NotNull ConfigurationContainer<Language> languageConfigurationContainer(final @NotNull Path pluginPath) {
    return LanguageConfigurationHelper.create(pluginPath, Language.class);
  }

  /* ONLY IF YOU NEED TO USE CONFIGURATION
  @Provides
  @Singleton
  public @NotNull ConfigurationContainer<Configuration> configurationContainer(final @NotNull Path pluginPath) {
    return ConfigurationContainer.<Configuration>builder()
      .configTypeClass(Configuration.class)
      .folder(pluginPath)
      .shouldCopyDefaults(true)
      .build();
  }
  */

  /* ONLY IF YOU NEED TO ADD CUSTOM COMMAND PART TRANSLATIONS
  @Provides
  @Singleton
  public @NotNull ConfiguredTranslationProvider configuredTranslationProvider(final @NotNull ConfigurationContainer<Language> languageConfigurationContainer) {
    return key -> languageConfigurationContainer.configuration().command.translate(key);
  }
  */

  @Provides
  @Singleton
  public @NotNull ConfiguredTranslationProvider configuredTranslationProvider() {
    return ConfiguredTranslationProvider.EMPTY;
  }
}
