package es.revengenetwork.template.command;

import com.google.inject.Inject;
import es.revengenetwork.command.annotated.CommandClass;
import es.revengenetwork.command.annotated.annotation.Command;
import es.revengenetwork.fenix.paper.config.ConfigurationContainer;
import es.revengenetwork.fenix.paper.config.ConfigurationContainerManager;
import org.bukkit.command.CommandSender;
import es.revengenetwork.template.translation.Language;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("unused")
@Command(names = "reload", permission = "template.command.reload")
public final class ReloadSubcommand implements CommandClass {
  /* ONLY IF YOU NEED TO USE CONFIGURATION
  private final ConfigurationContainer<Configuration> configurationContainer;*/
  private final ConfigurationContainerManager configurationContainerManager;
  private final ConfigurationContainer<Language> languageConfigurationContainer;

  public @Inject ReloadSubcommand(/*final @NotNull ConfigurationContainer<Configuration> configurationContainer, */final @NotNull ConfigurationContainerManager configurationContainerManager, final @NotNull ConfigurationContainer<Language> languageConfigurationContainer) {
    /*this.configurationContainer = configurationContainer;*/
    this.configurationContainerManager = configurationContainerManager;
    this.languageConfigurationContainer = languageConfigurationContainer;
  }

  /* ONLY IF YOU NEED TO USE CONFIGURATION
  @Command(names = "config", permission = "template.command.reload.config")
  public void config(final @NotNull CommandSender sender) {
    this.configurationContainerManager.reload(sender, this.configurationContainer);
  }
   */

  @Command(names = "lang", permission = "template.command.reload.lang")
  public void lang(final @NotNull CommandSender sender) {
    this.configurationContainerManager.reload(sender, this.languageConfigurationContainer);
  }
}
