package es.revengenetwork.template;

import com.google.inject.Inject;
import com.google.inject.Injector;
import es.revengenetwork.fenix.inject.binder.ProtectedBinder;
import es.revengenetwork.fenix.paper.command.CommandRegistrationProcess;
import es.revengenetwork.fenix.paper.listener.EventHandlerRegistrationProcess;
import es.revengenetwork.fenix.paper.plugin.InjectedPlugin;
import es.revengenetwork.fenix.paper.power.PowerProcessExecutor;
import java.util.List;
import es.revengenetwork.template.command.TemplateCommand;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("unused")
public final class RevengeTemplatePlugin extends InjectedPlugin {
  @Inject private Injector injector;

  @Override
  public void onEnable() {
    try {
      PowerProcessExecutor.create(
        EventHandlerRegistrationProcess.create(/* YOUR EVENT HANDLER CLASSES HERE */),
        CommandRegistrationProcess.create(null, List.of(TemplateCommand.class)))
        .execute(this, this.injector);
    } catch (final Exception e) {
      this.getSLF4JLogger().error("Failed to enable the plugin, disabling it...", e);
      this.getServer().getPluginManager().disablePlugin(this);
    }
  }

  @Override
  public void configure(final @NotNull ProtectedBinder binder) {
    binder.install(new MainModule());
  }
}
