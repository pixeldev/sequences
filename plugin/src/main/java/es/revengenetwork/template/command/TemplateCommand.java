package es.revengenetwork.template.command;

import es.revengenetwork.command.annotated.CommandClass;
import es.revengenetwork.command.annotated.annotation.Command;
import es.revengenetwork.command.annotated.annotation.SubCommandClasses;

@SuppressWarnings("unused")
@Command(names = "template", permission = "template.command")
@SubCommandClasses(ReloadSubcommand.class)
public final class TemplateCommand implements CommandClass {
}
