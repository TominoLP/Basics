package de.tomino.basics.utils;

public class Languages {

    public static String NoPermission;
    public static String PlayerNotFound;
    public static String ConsoleExecute;
    public static String GameModeSurvival;
    public static String GameModeCreative;
    public static String GameModeAdventure;
    public static String GameModeSpectator;
    public static String GameModeSurvival_Others;
    public static String GameModeCreative_Others;
    public static String GameModeAdventure_Others;
    public static String GameModeSpectator_Others;
    public static String InvalidGameMode;
    public static String BlockBreakActivated;
    public static String BlockBreakDeactivated;
    public static String AdminGUITitle;
    public static String AdminStopGUI;
    public static String AdminReloadGUI;
    public static String AdminMaintenanceGUI;
    public static String AdminStop;
    public static String AdminMaintenanceON;
    public static String AdminMaintenanceOFF;
    public static String MaintenanceKickMessage;
    public static String HealAll;
    public static String FlyEnabled;
    public static String FlyDisabled;
    public static String FlySpeedMAX;
    public static String FlySpeedNormal;
    public static String FlySpeedInvalid;
    public static String FlySpeed;
    public static String TeleportSelf;
    public static String TeleportOther;
    public static String TeleportOtherToSelf;
    public static String TeleportAll;
    public static String TimeSkip;

    public static void setLanguage() {

        switch (Config.LANGUAGE) {
            case "en":

                // English Language

                // Misc
                NoPermission = "You don't have permission to do that!";
                PlayerNotFound = "§cPlayer %Player% not found!";
                ConsoleExecute = "You can't execute this command from console!";


                // GameMode Commands
                GameModeSurvival = "§aYou are now in survival mode!";
                GameModeCreative = "§aYou are now in creative mode!";
                GameModeAdventure = "§aYou are now in adventure mode!";
                GameModeSpectator = "§aYou are now in spectator mode!";

                GameModeSurvival_Others = "§aYou set %Player% to survival mode!";
                GameModeCreative_Others = "§aYou set %Player% to creative mode!";
                GameModeAdventure_Others = "§aYou set %Player% to adventure mode!";
                GameModeSpectator_Others = "§aYou set %Player% to spectator mode!";

                InvalidGameMode = "§cInvalid gamemode!\n Use /gm [gamemode]";

                // BlockBreak Commands
                BlockBreakActivated = "§aBlock break is now activated!";
                BlockBreakDeactivated = "§aBlock break is now deactivated!";

                // Admin Commands
                AdminGUITitle = "Admin GUI";
                AdminStopGUI = "§cStop Server";
                AdminReloadGUI = "§cReload Server";
                AdminMaintenanceGUI = "§cMaintenance";

                AdminStop = "§cStopping Server in 3m...";
                AdminMaintenanceON = "§cMaintenance mode is now activated!";
                AdminMaintenanceOFF = "§cMaintenance mode is now deactivated!";
                MaintenanceKickMessage = "§cServer is in maintenance mode!";

                // HealAll Command
                HealAll = "§aYou have been healed!";

                // Fly Command
                FlyEnabled = "§aYou are now able flying!";
                FlyDisabled = "§aYou are now unable flying!";
                FlySpeedMAX = "§aFly Speed can`t be greater then 10!";
                FlySpeedNormal = "§aFly Speed is now 1!";
                FlySpeedInvalid = "§cInvalid fly speed!";
                FlySpeed = "§aFly Speed is now %FlySpeed%!";

                // Teleport Command
                TeleportSelf = "§aYou have been teleported to %target%!";
                TeleportOther = "§a %executor% teleported you to %target%!";
                TeleportOtherToSelf = "§aYou teleported %target% to you!";
                TeleportAll = "§aYou teleported all players to you!";

                // TimeSkip Command
                TimeSkip = "§aAccelerating...";

                break;
            case "de":

                // German Language

                // Misc
                NoPermission = "Du hast keine Rechte dazu!";
                PlayerNotFound = "§cSpieler %Player% nicht gefunden!";
                ConsoleExecute = "Du kannst diesen Befehl nicht von der Konsole ausführen!";

                // GameMode Commands
                GameModeSurvival = "§aDu bist nun im Survival-Modus!";
                GameModeCreative = "§aDu bist nun im Creative-Modus!";
                GameModeAdventure = "§aDu bist nun im Adventure-Modus!";
                GameModeSpectator = "§aDu bist nun im Spectator-Modus!";

                GameModeSurvival_Others = "§aDu hast %Player% in den Survival-Modus gesetzt!";
                GameModeCreative_Others = "§aDu hast %Player% in den Creative-Modus gesetzt!";
                GameModeAdventure_Others = "§aDu hast %Player% in den Adventure-Modus gesetzt!";
                GameModeSpectator_Others = "§aDu hast %Player% in den Spectator-Modus gesetzt!";

                InvalidGameMode = "§cUngültiger Gamemode!\n Benutze /gm [gamemode]";

                // BlockBreak Commands
                BlockBreakActivated = "§aAbauen ist nun aktiviert!";
                BlockBreakDeactivated = "§aAbauen ist nun deaktiviert!";

                // Admin Commands
                AdminGUITitle = "Admin GUI";
                AdminStopGUI = "§cStoppe Server";
                AdminReloadGUI = "§cReload Server";
                AdminMaintenanceGUI = "§cWartung";

                AdminStop = "§cStoppe Server in 3m...";
                AdminMaintenanceON = "§cWartungsmodus ist nun aktiviert!";
                AdminMaintenanceOFF = "§cWartungsmodus ist nun deaktiviert!";
                MaintenanceKickMessage = "§cServer ist im Wartungsmodus!";

                // Heal Commands
                HealAll = "§aDu wurdest geheilt!";

                // Fly Commands
                FlyEnabled = "§aDu kannst nun fliegen!";
                FlyDisabled = "§aDu kannst nun nicht mehr fliegen!";
                FlySpeedMAX = "§aDie Fluggeschwindigkeit kann nicht höher als 10 sein!";
                FlySpeedNormal = "§aDie Fluggeschwindigkeit ist nun 1!";
                FlySpeedInvalid = "§cUngültige Fluggeschwindigkeit!";
                FlySpeed = "§aDie Fluggeschwindigkeit ist nun %FlySpeed%!";

                // Teleport Command
                TeleportSelf = "§aDu wurdest zu §e %target% §ateleportiert.";
                TeleportOther = "§a %executor% hat dich zu §e %target% §ateleportiert.";
                TeleportOtherToSelf = "§aDu hast §e %target% §a zu dir teleportiert.";
                TeleportAll = "§aDu hast alle Spieler zu dir teleportiert.";

                // TimeSkip Command
                TimeSkip = "§aÜberspringe...";

                break;
            case "es":

                // Spanish Language

                // Misc
                NoPermission = "No tienes permiso para ejecutar eso!";
                PlayerNotFound = "§cJugador %Player% no encontrado!";
                ConsoleExecute = "No puedes ejecutar este comando desde la consola!";

                // GameMode Commands
                GameModeSurvival = "§aHas cambiado tu modo de juego a §eSurvival§a!";
                GameModeCreative = "§aHas cambiado tu modo de juego a §eCreative§a!";
                GameModeAdventure = "§aHas cambiado tu modo de juego a §eAdventure§a!";
                GameModeSpectator = "§aHas cambiado tu modo de juego a §eSpectator§a!";

                GameModeSurvival_Others = "§aHas cambiado el modo de juego de %Player% a §eSurvival§a!";
                GameModeCreative_Others = "§aHas cambiado el modo de juego de %Player% a §eCreative§a!";
                GameModeAdventure_Others = "§aHas cambiado el modo de juego de %Player% a §eAdventure§a!";
                GameModeSpectator_Others = "§aHas cambiado el modo de juego de %Player% a §eSpectator§a!";

                InvalidGameMode = "§cModo de juego inválido!\n Usa /gm [modo]";

                // BlockBreak Commands
                BlockBreakActivated = "§aAhora puedes romper bloques!";
                BlockBreakDeactivated = "§aAhora no puedes romper bloques!";

                // Admin Commands
                AdminGUITitle = "GUI Admin";
                AdminStopGUI = "§cParar Servidor";
                AdminReloadGUI = "§cRecargar Servidor";
                AdminMaintenanceGUI = "§cMantenimiento";

                AdminStop = "§cParar Servidor en 3m...";
                AdminMaintenanceON = "§cMantenimiento activado!";
                AdminMaintenanceOFF = "§cMantenimiento desactivado!";
                MaintenanceKickMessage = "§cServidor en mantenimiento!";
                // Heal Commands
                HealAll = "§aHas sido curado!";

                // Fly Commands
                FlyEnabled = "§aHas activado el vuelo!";
                FlyDisabled = "§aHas desactivado el vuelo!";
                FlySpeedMAX = "§aLa velocidad de vuelo no puede ser superior a 10!";
                FlySpeedNormal = "§aLa velocidad de vuelo ha sido restaurada a 1!";
                FlySpeedInvalid = "§cVelocidad de vuelo inválida!";
                FlySpeed = "§aLa velocidad de vuelo ha sido cambiada a %FlySpeed%!";

                // Teleport Command
                TeleportSelf = "§aHas sido teletransportado a §e %target%.";
                TeleportOther = "§a %executor% te ha teletransportado a §e %target%.";
                TeleportOtherToSelf = "§aHas teletransportado a §e %target%.";
                TeleportAll = "§aHas teletransportado a todos los jugadores.";

                // TimeSkip Command
                TimeSkip = "§aSaltando...";

                break;
            case "fr":

                // French Language

                // Misc
                NoPermission = "Vous n'avez pas la permission d'exécuter cela!";
                PlayerNotFound = "§cJoueur %Player% non trouvé!";
                ConsoleExecute = "Vous ne pouvez pas exécuter cela depuis la console!";

                // GameMode Commands
                GameModeSurvival = "§aVous avez changé votre mode de jeu en §eSurvival§a!";
                GameModeCreative = "§aVous avez changé votre mode de jeu en §eCreative§a!";
                GameModeAdventure = "§aVous avez changé votre mode de jeu en §eAdventure§a!";
                GameModeSpectator = "§aVous avez changé votre mode de jeu en §eSpectator§a!";

                GameModeSurvival_Others = "§aVous avez changé le mode de jeu de %Player% en §eSurvival§a!";
                GameModeCreative_Others = "§aVous avez changé le mode de jeu de %Player% en §eCreative§a!";
                GameModeAdventure_Others = "§aVous avez changé le mode de jeu de %Player% en §eAdventure§a!";
                GameModeSpectator_Others = "§aVous avez changé le mode de jeu de %Player% en §eSpectator§a!";

                InvalidGameMode = "§cMode de jeu invalide!\n Utilisez /gm [mode]";

                // BlockBreak Commands
                BlockBreakActivated = "§aVous pouvez maintenant breaker des blocs!";
                BlockBreakDeactivated = "§aVous ne pouvez plus breaker des blocs!";

                // Admin Commands
                AdminGUITitle = "GUI Admin";
                AdminStopGUI = "§cArrêter Serveur";
                AdminReloadGUI = "§cRecharger Serveur";
                AdminMaintenanceGUI = "§cMaintenance";

                AdminStop = "§cArrêter Serveur dans 3m...";
                AdminMaintenanceON = "§cMaintenance activée!";
                AdminMaintenanceOFF = "§cMaintenance désactivée!";
                MaintenanceKickMessage = "§cServeur en maintenance!";

                // Heal Commands
                HealAll = "§aVous avez été soigné!";

                // Fly Commands
                FlyEnabled = "§aVous avez activé le vol!";
                FlyDisabled = "§aVous avez désactivé le vol!";
                FlySpeedMAX = "§aLa vitesse de vol ne peut pas être supérieur à 10!";

                // Teleport Command
                TeleportSelf = "§aVous avez été téléporté à §e %target%.";
                TeleportOther = "§a %executor% vous a téléporté à §e %target%.";
                TeleportOtherToSelf = "§aVous avez téléporté à §e %target%.";
                TeleportAll = "§aVous avez téléporté tous les joueurs.";


                // TimeSkip Command
                TimeSkip = "§aSautant...";

                break;
            case "it":

                // Italian Language

                // Misc
                NoPermission = "Non hai il permesso di eseguire questo!";
                PlayerNotFound = "§cGiocatore %Player% non trovato!";
                ConsoleExecute = "Non puoi eseguire questo da console!";

                // GameMode Commands
                GameModeSurvival = "§aHai cambiato il tuo modo di gioco in §eSurvival§a!";
                GameModeCreative = "§aHai cambiato il tuo modo di gioco in §eCreative§a!";
                GameModeAdventure = "§aHai cambiato il tuo modo di gioco in §eAdventure§a!";
                GameModeSpectator = "§aHai cambiato il tuo modo di gioco in §eSpectator§a!";

                GameModeSurvival_Others = "§aHai cambiato il modo di gioco di %Player% in §eSurvival§a!";
                GameModeCreative_Others = "§aHai cambiato il modo di gioco di %Player% in §eCreative§a!";
                GameModeAdventure_Others = "§aHai cambiato il modo di gioco di %Player% in §eAdventure§a!";
                GameModeSpectator_Others = "§aHai cambiato il modo di gioco di %Player% in §eSpectator§a!";

                InvalidGameMode = "§cModo di gioco non valido!\n Usa /gm [mode]";

                // BlockBreak Commands
                BlockBreakActivated = "§aOra puoi rompere i blocchi!";
                BlockBreakDeactivated = "§aOra non puoi rompere i blocchi!";

                // Admin Commands
                AdminGUITitle = "GUI Admin";
                AdminStopGUI = "§cArrestare Server";
                AdminReloadGUI = "§cRicaricare Server";
                AdminMaintenanceGUI = "§cManutenzione";

                AdminStop = "§cArrestare Server in 3m...";
                AdminMaintenanceON = "§cManutenzione attivata!";
                AdminMaintenanceOFF = "§cManutenzione disattivata!";
                MaintenanceKickMessage = "§cServer in manutenzione!";

                // Heal Commands
                HealAll = "§aTi sei curato!";

                // Fly Commands
                FlyEnabled = "§aHai attivato il volo!";
                FlyDisabled = "§aHai disattivato il volo!";
                FlySpeedMAX = "§aLa velocità di volo non può essere superiore a 10!";

                // Teleport Command
                TeleportSelf = "§aTi sei spostato a §e %target%.";
                TeleportOther = "§a %executor% ti ha spostato a §e %target%.";
                TeleportOtherToSelf = "§aTi sei spostato a §e %target%.";
                TeleportAll = "§aTi sei spostato a tutti i giocatori.";

                // TimeSkip Command
                TimeSkip = "§aSaltando...";
                break;
            default:

                Config.LANGUAGE = "en";
                Config.load();
                setLanguage();
                break;
        }
    }
}

