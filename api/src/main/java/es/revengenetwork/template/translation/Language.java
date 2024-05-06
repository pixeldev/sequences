package es.revengenetwork.template.translation;

import es.revengenetwork.fenix.paper.config.ConfigurationFile;
import es.revengenetwork.fenix.paper.translate.mode.MessageModes;
import es.revengenetwork.message.send.message.ComponentMessage;
import org.spongepowered.configurate.objectmapping.ConfigSerializable;

/**
 * This class is responsible for provide all the translations of the plugin.
 *
 * @since 0.0.1
 */
@ConfigSerializable
@SuppressWarnings("ALL")
public final class Language implements ConfigurationFile {
  /**
   * This message should be sent when any error occurs or there is an unexpected behavior.
   * It's just a generic message to avoid creating multiple type of error messages, so it
   * increases the user experience.
   *
   * @since 0.0.1
   */
  public ComponentMessage processError = ComponentMessage.ofMiniMessage(MessageModes.ERROR, "<red>Ha ocurrido un error, si esto continúa contacta con un administrador.");
  /**
   * An instance of our {@link CommandLanguage} to get translations for our custom {@link es.revengenetwork.command.part.CommandPart}s.
   *
   * @since 0.0.1
   */
  public CommandLanguage command = new CommandLanguage();
}
