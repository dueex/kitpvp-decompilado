package me.iBesty;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;

import me.iBesty.Comandos.Administrador;
import me.iBesty.Comandos.Broadcast;
import me.iBesty.Comandos.Build;
import me.iBesty.Comandos.ClearChat;
import me.iBesty.Comandos.Fly;
import me.iBesty.Comandos.Gamemode;
import me.iBesty.Comandos.Head;
import me.iBesty.Comandos.Inventario;
import me.iBesty.Comandos.Ip;
import me.iBesty.Comandos.Kit;
import me.iBesty.Comandos.KitVip;
import me.iBesty.Comandos.KitsAdicionais;
import me.iBesty.Comandos.Refil;
import me.iBesty.Comandos.Report;
import me.iBesty.Comandos.Reset;
import me.iBesty.Comandos.SKit;
import me.iBesty.Comandos.StaffChat;
import me.iBesty.Comandos.Tag;
import me.iBesty.Comandos.Tell;
import me.iBesty.Comandos.Tp;
import me.iBesty.Comandos.Warps;
import me.iBesty.Eventos.Mensagens;
import me.iBesty.Eventos.Sopa;
import me.iBesty.Kits.Anchor;
import me.iBesty.Kits.Archer;
import me.iBesty.Kits.Backpacker;
import me.iBesty.Kits.Critical;
import me.iBesty.Kits.Darkmage;
import me.iBesty.Kits.Fisherman;
import me.iBesty.Kits.Fujao;
import me.iBesty.Kits.Gladiator;
import me.iBesty.Kits.Gorila;
import me.iBesty.Kits.Grandpa;
import me.iBesty.Kits.Grappler1;
import me.iBesty.Kits.Grenadier;
import me.iBesty.Kits.HitKill;
import me.iBesty.Kits.Hulk;
import me.iBesty.Kits.Jellyfish;
import me.iBesty.Kits.Kangaroo;
import me.iBesty.Kits.Ninja;
import me.iBesty.Kits.Phantom;
import me.iBesty.Kits.Pinguim;
import me.iBesty.Kits.Puurga;
import me.iBesty.Kits.PvP;
import me.iBesty.Kits.Rider;
import me.iBesty.Kits.Snail;
import me.iBesty.Kits.Sniper;
import me.iBesty.Kits.Specialist;
import me.iBesty.Kits.Stomper;
import me.iBesty.Kits.Thor;
import me.iBesty.Kits.Viking;
import me.iBesty.Kits.Viper;
import me.iBesty.Listener.All;
import me.iBesty.Listener.Array;
import me.iBesty.Listener.CombatLog;
import me.iBesty.Listener.CorNaPlaca;
import me.iBesty.Listener.Drops;
import me.iBesty.Listener.Esponja;
import me.iBesty.Listener.KillAndDeath;
import me.iBesty.Listener.KillsStreak;
import me.iBesty.Listener.Nerfs;
import me.iBesty.Listener.PlacaDeSopa;
import me.iBesty.Listener.QuandoEntrar;
import me.iBesty.Listener.QuandoMorrer;

public class Main extends JavaPlugin {
	ArrayList<String> a1 = new ArrayList<String>();
	ArrayList<String> a2 = new ArrayList<String>();
	public static final List<Player> warping = new ArrayList<Player>();
	public static final List<Player> delay = new ArrayList<Player>();

	public void onEnable() {
		PluginManager pm = Bukkit.getServer().getPluginManager();

		pm.registerEvents(new HitKill(this), this);
		pm.registerEvents(new Jellyfish(this), this);
		pm.registerEvents(new QuandoMorrer(), this);
		pm.registerEvents(new Drops(this), this);
		pm.registerEvents(new Mensagens(), this);
		pm.registerEvents(new Kangaroo(this), this);
		pm.registerEvents(new Kit(this), this);
		pm.registerEvents(new Sopa(this), this);
		pm.registerEvents(new Rider(this), this);
		pm.registerEvents(new QuandoEntrar(), this);
		pm.registerEvents(new Anchor(this), this);
		pm.registerEvents(new Snail(this), this);
		pm.registerEvents(new Viper(this), this);
		pm.registerEvents(new Fisherman(this), this);
		pm.registerEvents(new Phantom(this), this);
		pm.registerEvents(new Specialist(this), this);
		pm.registerEvents(new Thor(this), this);
		pm.registerEvents(new Viking(this), this);
		pm.registerEvents(new Stomper(this), this);
		pm.registerEvents(new Hulk(this), this);
		pm.registerEvents(new Archer(this), this);
		pm.registerEvents(new Gladiator(this), this);
		pm.registerEvents(new Nerfs(this), this);
		pm.registerEvents(new Administrador(this), this);
		pm.registerEvents(new Esponja(this), this);
		pm.registerEvents(new KillsStreak(this), this);
		pm.registerEvents(new CorNaPlaca(this), this);
		pm.registerEvents(new Warps(this), this);
		pm.registerEvents(new PlacaDeSopa(this), this);
		pm.registerEvents(new KillAndDeath(this), this);
		pm.registerEvents(new CombatLog(this), this);
		pm.registerEvents(new All(this), this);
		pm.registerEvents(new KitVip(this), this);
		pm.registerEvents(new Pinguim(), this);
		pm.registerEvents(new Ninja(this), this);
		pm.registerEvents(new Backpacker(this), this);
		pm.registerEvents(new Gorila(this), this);
		pm.registerEvents(new Fujao(this), this);
		pm.registerEvents(new Grappler1(this), this);
		pm.registerEvents(new Build(), this);
		pm.registerEvents(new Sniper(this), this);
		pm.registerEvents(new Puurga(), this);
		pm.registerEvents(new SKit(), this);
		pm.registerEvents(new Critical(), this);
		pm.registerEvents(new Grenadier(this), this);
		pm.registerEvents(new Darkmage(), this);
		getCommand("darkmage").setExecutor(new Darkmage());
		getCommand("granadier").setExecutor(new Grenadier(this));
		getCommand("critical").setExecutor(new Critical());
		getCommand("skit").setExecutor(new SKit());
		getCommand("togglepvp").setExecutor(new SKit());
		getCommand("puurga").setExecutor(new Puurga());
		getCommand("sniper").setExecutor(new Sniper(this));
		getCommand("tell").setExecutor(new Tell(this));
		getCommand("ip").setExecutor(new Ip(this));
		getCommand("build").setExecutor(new Build());
		getCommand("msg").setExecutor(new Tell(this));
		getCommand("grappler").setExecutor(new Grappler1(this));
		getCommand("fujao").setExecutor(new Fujao(this));
		getCommand("gorila").setExecutor(new Gorila(this));
		getCommand("tp").setExecutor(new Tp());
		getCommand("refiller").setExecutor(new Backpacker(this));
		getCommand("pinguim").setExecutor(new Pinguim());
		getCommand("ninja").setExecutor(new Ninja(this));
		getCommand("s").setExecutor(new StaffChat());
		getCommand("kit").setExecutor(new Kit(this));
		getCommand("sopa").setExecutor(new Refil(this));
		getCommand("grandpa").setExecutor(new Grandpa(this));
		getCommand("hitkill").setExecutor(new HitKill(this));
		getCommand("jellyfish").setExecutor(new Jellyfish(this));
		getCommand("pvp").setExecutor(new PvP());
		getCommand("reset").setExecutor(new Reset());
		getCommand("rider").setExecutor(new Rider(this));
		getCommand("anchor").setExecutor(new Anchor(this));
		getCommand("snail").setExecutor(new Snail(this));
		getCommand("viper").setExecutor(new Viper(this));
		getCommand("fisherman").setExecutor(new Fisherman(this));
		getCommand("specialist").setExecutor(new Specialist(this));
		getCommand("phantom").setExecutor(new Phantom(this));
		getCommand("thor").setExecutor(new Thor(this));
		getCommand("viking").setExecutor(new Viking(this));
		getCommand("stomper").setExecutor(new Stomper(this));
		getCommand("archer").setExecutor(new Archer(this));
		getCommand("gladiator").setExecutor(new Gladiator(this));
		getCommand("bc").setExecutor(new Broadcast(this));
		getCommand("broadcast").setExecutor(new Broadcast(this));
		getCommand("cchat").setExecutor(new ClearChat());
		getCommand("fly").setExecutor(new Fly(this));
		getCommand("gm").setExecutor(new Gamemode(this));
		getCommand("head").setExecutor(new Head(this));
		getCommand("inv").setExecutor(new Inventario(this));
		getCommand("admin").setExecutor(new Administrador(this));
		getCommand("vis").setExecutor(new Administrador(this));
		getCommand("invis").setExecutor(new Administrador(this));
		getCommand("kangaroo").setExecutor(new KitsAdicionais());
		getCommand("hulk").setExecutor(new KitsAdicionais());
		getCommand("warps").setExecutor(new Warps(this));
		getCommand("report").setExecutor(new Report(this));
		getCommand("tag").setExecutor(new Tag());
		getCommand("kitvip").setExecutor(new KitVip(this));
	}

	public static Plugin getPlugin() {
		return Bukkit.getServer().getPluginManager().getPlugin("Kits");
	}

	public void tp(Player a, Location loc) {
		this.a1.add(a.getName());
		Player p = a;
		Location loc1 = loc;
		this.a1.remove(p.getName());
		p.sendMessage(ChatColor.GREEN + "Teleportado com sucesso!");
		p.teleport(loc1);
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		final ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
		ItemMeta sMeta = sopa.getItemMeta();
		sMeta.setDisplayName("ß6Sopa");
		sopa.setItemMeta(sMeta);
		if ((sender instanceof Player)) {
			final Player p = (Player) sender;
			if (!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.RED + "Voce n√£o pode usa admin!");
				return true;
			}
			if (cmd.getName().equalsIgnoreCase("setrdm")) {
				if (!p.hasPermission("admin.mod")) {
					sender.sendMessage(ChatColor.RED + "Voce nao tem permissao para isso!");
					return true;
				}
				getConfig().set("RdmWorld", p.getLocation().getWorld().getName());
				getConfig().set("RdmX", Double.valueOf(p.getLocation().getX()));
				getConfig().set("RdmY", Double.valueOf(p.getLocation().getY()));
				getConfig().set("RdmZ", Double.valueOf(p.getLocation().getZ()));
				saveConfig();
				p.sendMessage("ß7ßoReiDaMesa setado!");
				return true;
			}
			if (cmd.getName().equalsIgnoreCase("setmdr")) {
				if (!p.hasPermission("admin.mod")) {
					sender.sendMessage(ChatColor.RED + "Voce nao tem permissao para isso!");
					return true;
				}
				getConfig().set("MdrWorld", p.getLocation().getWorld().getName());
				getConfig().set("MdrX", Double.valueOf(p.getLocation().getX()));
				getConfig().set("MdrY", Double.valueOf(p.getLocation().getY()));
				getConfig().set("MdrZ", Double.valueOf(p.getLocation().getZ()));
				saveConfig();
				p.sendMessage("ß7ßoMaeDaRua setado!");
				return true;
			}
			if (cmd.getName().equalsIgnoreCase("setspawn")) {
				if (!p.hasPermission("admin.mod")) {
					sender.sendMessage(ChatColor.RED + "Voce nao tem permissao para isso!");
					return true;
				}
				getConfig().set("SpawnWorld", p.getLocation().getWorld().getName());
				getConfig().set("SpawnX", Double.valueOf(p.getLocation().getX()));
				getConfig().set("SpawnY", Double.valueOf(p.getLocation().getY()));
				getConfig().set("SpawnZ", Double.valueOf(p.getLocation().getZ()));
				saveConfig();
				World world = p.getWorld();
				Location loc = p.getLocation();
				world.setSpawnLocation(loc.getBlockX(), loc.getBlockY() + 1, loc.getBlockZ());
				p.sendMessage("ß7ßoSpawn setado!");
				return true;
			}
			if (cmd.getName().equalsIgnoreCase("setfps")) {
				if (!p.hasPermission("admin.mod")) {
					sender.sendMessage(ChatColor.RED + "Voce nao tem permissao para isso!");
					return true;
				}
				getConfig().set("FpsWorld", p.getLocation().getWorld().getName());
				getConfig().set("FpsX", Double.valueOf(p.getLocation().getX()));
				getConfig().set("FpsY", Double.valueOf(p.getLocation().getY()));
				getConfig().set("FpsZ", Double.valueOf(p.getLocation().getZ()));
				saveConfig();
				p.sendMessage("ß7ßoFps setado!");
				return true;
			}
			if (cmd.getName().equalsIgnoreCase("setchallenge")) {
				if (!p.hasPermission("admin.mod")) {
					sender.sendMessage(ChatColor.RED + "Voce nao tem permissao para isso!");
					return true;
				}
				getConfig().set("ChallengeWorld", p.getLocation().getWorld().getName());
				getConfig().set("ChallengeX", Double.valueOf(p.getLocation().getX()));
				getConfig().set("ChallengeY", Double.valueOf(p.getLocation().getY()));
				getConfig().set("ChallengeZ", Double.valueOf(p.getLocation().getZ()));
				saveConfig();
				p.sendMessage("ß7ßoChallenge setado!");
				return true;
			}
			if (cmd.getName().equalsIgnoreCase("rdm")) {
				p.sendMessage("ßcßoVoce sera teleportado em 5 segundos");
				warping.add(p);
				Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
					public void run() {
						if (Main.warping.contains(p)) {
							for (PotionEffect effect : p.getActivePotionEffects()) {
								p.removePotionEffect(effect.getType());
							}
							World w = Bukkit.getServer().getWorld(Main.this.getConfig().getString("RdmWorld"));
							double x = Main.this.getConfig().getDouble("RdmX");
							double y = Main.this.getConfig().getDouble("RdmY");
							double z = Main.this.getConfig().getDouble("RdmZ");
							PlayerInventory inv = p.getInventory();
							p.teleport(new Location(w, x, y, z));
							p.getInventory().clear();
							Array.used.add(p.getName());
							ItemStack espada = new ItemStack(Material.STONE_SWORD);
							inv.addItem(new ItemStack[] { espada });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							p.sendMessage("ß7ßoVoce foi teletransportado para o " + ChatColor.RED + "ßoReiDaMesa!");
							Main.warping.remove(p);
						}
					}
				}, 100L);
			}
			if (cmd.getName().equalsIgnoreCase("mdr")) {
				p.sendMessage("ßaßoVoce sera teleportado em 5 segundos");
				warping.add(p);
				Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
					public void run() {
						if (Main.warping.contains(p)) {
							for (PotionEffect effect : p.getActivePotionEffects()) {
								p.removePotionEffect(effect.getType());
							}
							Array.used.add(p.getName());
							World w = Bukkit.getServer().getWorld(Main.this.getConfig().getString("MdrWorld"));
							double x = Main.this.getConfig().getDouble("MdrX");
							double y = Main.this.getConfig().getDouble("MdrY");
							double z = Main.this.getConfig().getDouble("MdrZ");
							PlayerInventory inv = p.getInventory();
							p.teleport(new Location(w, x, y, z));
							p.getInventory().clear();
							ItemStack espada = new ItemStack(Material.STONE_SWORD);
							inv.addItem(new ItemStack[] { espada });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							p.sendMessage("ß7ßoVoce foi teletransportado para o " + ChatColor.RED + "ßoMDR!");
							Main.warping.remove(p);
						}
					}
				}, 100L);
			}
			if (cmd.getName().equalsIgnoreCase("challenge")) {
				p.sendMessage("ßcßoVoce sera teleportado em 5 segundos");
				warping.add(p);
				Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
					public void run() {
						if (Main.warping.contains(p)) {
							for (PotionEffect effect : p.getActivePotionEffects()) {
								p.removePotionEffect(effect.getType());
							}
							World w = Bukkit.getServer().getWorld(Main.this.getConfig().getString("ChallengeWorld"));
							double x = Main.this.getConfig().getDouble("ChallengeX");
							double y = Main.this.getConfig().getDouble("ChallengeY");
							double z = Main.this.getConfig().getDouble("ChallengeZ");
							PlayerInventory inv = p.getInventory();
							p.teleport(new Location(w, x, y, z));
							p.getInventory().clear();

							ItemStack espada = new ItemStack(Material.STONE_SWORD);
							espada.addEnchantment(Enchantment.DAMAGE_ALL, 1);
							inv.addItem(new ItemStack[] { espada });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							inv.addItem(new ItemStack[] { sopa });
							p.sendMessage(
									"ß7ßoVoce foi teletransportado para o " + ChatColor.RED + "ßoLava Challenge!");
							Main.warping.remove(p);
						}
					}
				}, 100L);
			}
			if (cmd.getName().equalsIgnoreCase("fps")) {
				p.sendMessage("ßcßoVoce sera teleportado em 5 segundos");
				warping.add(p);
				Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
					public void run() {
						if (Main.warping.contains(p)) {
							for (PotionEffect effect : p.getActivePotionEffects()) {
								p.removePotionEffect(effect.getType());
							}
							ItemStack espada = new ItemStack(Material.STONE_SWORD);
							espada.addEnchantment(Enchantment.DAMAGE_ALL, 1);
							World w = Bukkit.getServer().getWorld(Main.this.getConfig().getString("FpsWorld"));
							double x = Main.this.getConfig().getDouble("FpsX");
							double y = Main.this.getConfig().getDouble("FpsY");
							double z = Main.this.getConfig().getDouble("FpsZ");
							p.teleport(new Location(w, x, y, z));
							p.sendMessage("ß7ßoVoce foi teletransportado para a " + ChatColor.RED + "ßoWarp Fps!");
							Main.warping.remove(p);
							p.getInventory().clear();
							Array.pvp.add(p.getName());
							Array.used.add(p.getName());
							p.getInventory().addItem(new ItemStack[] { espada });
							for (int i = 0; i <= 34; i++) {
								p.getInventory().addItem(new ItemStack[] { sopa });
							}
						}
					}
				}, 100L);
			}
			if (cmd.getName().equalsIgnoreCase("spawn")) {
				p.sendMessage("ßaßoVoce sera teleportado em 5 segundos");
				warping.add(p);
				Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
					public void run() {
						if (Main.warping.contains(p)) {
							p.teleport(p.getWorld().getSpawnLocation());

							p.getInventory().clear();
							for (PotionEffect effect : p.getActivePotionEffects()) {
								p.removePotionEffect(effect.getType());
							}
							p.getInventory().setArmorContents(null);
							for (PotionEffect effect : p.getActivePotionEffects()) {
								p.removePotionEffect(effect.getType());
							}
							p.sendMessage("ß7ßoVoce foi teletransportado para o " + ChatColor.RED + "ßoSpawn!");
							Main.warping.remove(p);

							World world = p.getWorld();
							Location loc = new Location(world, -674.0D, 92.0D, -1143.0D);

							Main.this.tp(p, loc);

							ItemStack a = new ItemStack(Material.BLAZE_POWDER);
							ItemMeta aa = a.getItemMeta();
							aa.setDisplayName("UltimateKits!");
							a.setItemMeta(aa);

							ItemStack kits = new ItemStack(Material.ENDER_CHEST);
							ItemMeta kitsm = kits.getItemMeta();
							kitsm.setDisplayName("ß4ßlKits");
							ArrayList<String> archerlore = new ArrayList<String>();
							archerlore.add("ßb-> MenuDeKits!");
							kitsm.setLore(archerlore);
							kits.setItemMeta(kitsm);

							ItemStack warps = new ItemStack(Material.PAPER);
							ItemMeta warpsm = warps.getItemMeta();
							warpsm.setDisplayName("ß9ßlWarps");
							ArrayList<String> warpslore = new ArrayList<String>();
							warpslore.add("ßb-> MenuDeWarps!");
							warpsm.setLore(warpslore);
							warps.setItemMeta(warpsm);

							p.getInventory().setItem(2, a);
							p.getInventory().setItem(3, kits);
							p.getInventory().setItem(4, a);
							p.getInventory().setItem(5, warps);
							p.getInventory().setItem(6, a);
						}
					}
				}, 100L);
			}
		}
		return false;
	}
}
