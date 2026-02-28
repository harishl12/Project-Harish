import { useState, useRef, useEffect, useCallback } from "react";

// ─── Icons (SVG inline) ────────────────────────────────────────────────────
const Icon = ({ d, size = 14, color = "currentColor", className = "" }) => (
  <svg width={size} height={size} viewBox="0 0 24 24" fill="none" stroke={color} strokeWidth="2" strokeLinecap="round" strokeLinejoin="round" className={className}>
    <path d={d} />
  </svg>
);
const icons = {
  terminal: "M4 17l6-6-6-6M12 19h8",
  folder: "M22 19a2 2 0 01-2 2H4a2 2 0 01-2-2V5a2 2 0 012-2h5l2 3h9a2 2 0 012 2z",
  folderOpen: "M5 19a2 2 0 01-2-2V7a2 2 0 012-2h4l2 2h4a2 2 0 012 2v1M5 19h14a2 2 0 002-2v-5a2 2 0 00-2-2H9a2 2 0 00-2 2v5a2 2 0 01-2 2z",
  file: "M14 2H6a2 2 0 00-2 2v16a2 2 0 002 2h12a2 2 0 002-2V8z M14 2v6h6",
  ssh: "M12 22s8-4 8-10V5l-8-3-8 3v7c0 6 8 10 8 10z",
  plus: "M12 5v14M5 12h14",
  x: "M18 6L6 18M6 6l12 12",
  chevronRight: "M9 18l6-6-6-6",
  chevronDown: "M6 9l6 6 6-6",
  globe: "M12 2a10 10 0 100 20 10 10 0 000-20zM2 12h20M12 2a15.3 15.3 0 010 20M12 2a15.3 15.3 0 000 20",
  server: "M2 8a4 4 0 014-4h12a4 4 0 014 4v1a4 4 0 01-4 4H6a4 4 0 01-4-4V8zM6 20h.01M10 20h.01",
  settings: "M12 20a8 8 0 100-16 8 8 0 000 16zM12 14a2 2 0 100-4 2 2 0 000 4z",
  download: "M21 15v4a2 2 0 01-2 2H5a2 2 0 01-2-2v-4M7 10l5 5 5-5M12 15V3",
  upload: "M21 15v4a2 2 0 01-2 2H5a2 2 0 01-2-2v-4M17 8l-5-5-5 5M12 3v12",
  refresh: "M23 4v6h-6M1 20v-6h6M3.51 9a9 9 0 0114.85-3.36L23 10M1 14l4.64 4.36A9 9 0 0020.49 15",
  link: "M15 7h3a5 5 0 010 10h-3m-6 0H6A5 5 0 016 7h3M8 12h8",
  key: "M21 2l-2 2m-7.61 7.61a5.5 5.5 0 11-7.778 7.778 5.5 5.5 0 017.777-7.777zm0 0L15.5 7.5m0 0l3 3L22 7l-3-3m-3.5 3.5L19 4",
  rdp: "M2 3h20v14H2zM8 21h8M12 17v4",
  vnc: "M21 16V8a2 2 0 00-1-1.73l-7-4a2 2 0 00-2 0l-7 4A2 2 0 002 8v8a2 2 0 001 1.73l7 4a2 2 0 002 0l7-4A2 2 0 0021 16z",
  minimize: "M5 12h14",
  maximize: "M3 3h18v18H3z",
  close: "M18 6L6 18M6 6l12 12",
  search: "M21 21l-6-6m2-5a7 7 0 11-14 0 7 7 0 0114 0z",
  copy: "M8 17.929H6c-1.105 0-2-.912-2-2.036V5.036C4 3.91 4.895 3 6 3h8c1.105 0 2 .911 2 2.036v1.866m-6 .17h8c1.105 0 2 .91 2 2.035v10.857C20 21.09 19.105 22 18 22h-8c-1.105 0-2-.911-2-2.036V9.107c0-1.124.895-2.036 2-2.036z",
  trash: "M3 6h18M19 6v14a2 2 0 01-2 2H7a2 2 0 01-2-2V6m3 0V4a1 1 0 011-1h4a1 1 0 011 1v2",
  home: "M3 9l9-7 9 7v11a2 2 0 01-2 2H5a2 2 0 01-2-2z M9 22V12h6v10",
  lock: "M19 11H5a2 2 0 00-2 2v7a2 2 0 002 2h14a2 2 0 002-2v-7a2 2 0 00-2-2zM7 11V7a5 5 0 0110 0v4",
  wifi: "M5 12.55a11 11 0 0114.08 0M1.42 9a16 16 0 0121.16 0M8.53 16.11a6 6 0 016.95 0M12 20h.01",
  edit: "M11 4H4a2 2 0 00-2 2v14a2 2 0 002 2h14a2 2 0 002-2v-7M18.5 2.5a2.121 2.121 0 013 3L12 15l-4 1 1-4 9.5-9.5z",
  duplicate: "M7 9H2v13h13v-5M22 2H9v13h13V2z",
  connect: "M5 12h14M12 5l7 7-7 7",
  notepad: "M14 2H6a2 2 0 00-2 2v16a2 2 0 002 2h12a2 2 0 002-2V8zM14 2v6h6M16 13H8M16 17H8M10 9H8",
  tunnel: "M12 2L2 7l10 5 10-5-10-5zM2 17l10 5 10-5M2 12l10 5 10-5",
};

// ─── Mock session data ─────────────────────────────────────────────────────
const defaultSessions = [
  {
    id: "g1", name: "Production", type: "group", expanded: true,
    children: [
      { id: "s1", name: "web-server-01", type: "ssh", host: "192.168.1.10", port: 22, user: "ubuntu", color: "#4ade80" },
      { id: "s2", name: "db-primary",    type: "ssh", host: "192.168.1.20", port: 22, user: "root",   color: "#f97316" },
      { id: "s3", name: "load-balancer", type: "ssh", host: "192.168.1.5",  port: 22, user: "admin",  color: "#60a5fa" },
    ]
  },
  {
    id: "g2", name: "Development", type: "group", expanded: true,
    children: [
      { id: "s4", name: "dev-box",    type: "ssh", host: "10.0.0.50", port: 22,   user: "dev",   color: "#a78bfa" },
      { id: "s5", name: "staging-01", type: "rdp", host: "10.0.0.60", port: 3389, user: "admin", color: "#fb7185" },
    ]
  },
  {
    id: "g3", name: "Local", type: "group", expanded: true,
    children: [
      { id: "s6", name: "localhost", type: "local", host: "localhost", port: 22, user: "user", color: "#34d399" },
    ]
  },
];

const mockFileTree = [
  { name: "home", type: "dir", expanded: true, children: [
    { name: "ubuntu", type: "dir", expanded: true, children: [
      { name: ".bashrc",       type: "file", size: "3.5 KB", modified: "Feb 15 09:22" },
      { name: ".ssh", type: "dir", expanded: false, children: [
        { name: "authorized_keys", type: "file", size: "1.2 KB", modified: "Jan 10 14:30" },
        { name: "id_rsa",          type: "file", size: "3.3 KB", modified: "Jan 10 14:30" },
        { name: "id_rsa.pub",      type: "file", size: "0.7 KB", modified: "Jan 10 14:30" },
      ]},
      { name: "projects", type: "dir", expanded: false, children: [
        { name: "webapp",  type: "dir", expanded: false, children: [] },
        { name: "scripts", type: "dir", expanded: false, children: [] },
      ]},
      { name: "deploy.sh", type: "file", size: "842 B",  modified: "Feb 20 16:45" },
      { name: "README.md", type: "file", size: "2.1 KB", modified: "Feb 18 11:00" },
    ]},
  ]},
  { name: "etc", type: "dir", expanded: false, children: [
    { name: "nginx", type: "dir", expanded: false, children: [] },
    { name: "ssh",   type: "dir", expanded: false, children: [] },
    { name: "hosts", type: "file", size: "187 B", modified: "Jan 01 00:00" },
  ]},
  { name: "var", type: "dir", expanded: false, children: [] },
];

const defaultSshKeys = [
  { id: "k1", name: "Personal MacBook",  path: "~/.ssh/id_ed25519",     type: "ed25519", added: "Jan 10 2025", fingerprint: "SHA256:abc123..." },
  { id: "k2", name: "Work Laptop",       path: "~/.ssh/id_rsa_work",    type: "RSA 4096", added: "Mar 5 2025",  fingerprint: "SHA256:xyz789..." },
  { id: "k3", name: "Deploy Key (prod)", path: "~/.ssh/id_rsa_deploy",  type: "RSA 2048", added: "Jun 1 2025",  fingerprint: "SHA256:def456..." },
];

// ─── Terminal simulation ───────────────────────────────────────────────────
const simulateCommand = (cmd, host, user) => {
  const c = cmd.trim();
  if (!c) return "";
  if (c === "ls" || c === "ls -la" || c === "ls -l") {
    return c.includes("-l")
      ? `total 48\ndrwxr-xr-x 6 ${user} ${user} 4096 Feb 28 09:15 .\ndrwxr-xr-x 3 root  root  4096 Jan 01 00:00 ..\n-rw-r--r-- 1 ${user} ${user} 3524 Feb 15 09:22 .bashrc\n-rw-r--r-- 1 ${user} ${user}  220 Jan 01 00:00 .bash_logout\n-rw-r--r-- 1 ${user} ${user}  807 Jan 01 00:00 .profile\ndrwx------ 2 ${user} ${user} 4096 Jan 10 14:30 .ssh\ndrwxr-xr-x 4 ${user} ${user} 4096 Feb 20 16:40 projects\n-rwxr-xr-x 1 ${user} ${user}  842 Feb 20 16:45 deploy.sh\n-rw-r--r-- 1 ${user} ${user} 2156 Feb 18 11:00 README.md`
      : `.bashrc  .bash_logout  .profile  .ssh  projects  deploy.sh  README.md`;
  }
  if (c === "pwd") return `/home/${user}`;
  if (c.startsWith("cd ")) return "";
  if (c === "whoami") return user;
  if (c === "hostname") return host;
  if (c === "date") return new Date().toString();
  if (c === "uname -a") return `Linux ${host} 6.1.0-28-amd64 #1 SMP PREEMPT_DYNAMIC Debian 6.1.119-1 (2024-11-22) x86_64 GNU/Linux`;
  if (c === "uptime") return ` 09:15:33 up 47 days,  3:22,  2 users,  load average: 0.08, 0.12, 0.10`;
  if (c === "df -h") return `Filesystem      Size  Used Avail Use% Mounted on\n/dev/sda1        80G   42G   34G  56% /\ntmpfs           3.9G     0  3.9G   0% /dev/shm\n/dev/sdb1       200G  167G   24G  88% /data`;
  if (c === "free -h") return `              total        used        free      shared  buff/cache   available\nMem:           7.8G        2.1G        3.4G        124M        2.3G        5.3G\nSwap:          2.0G          0B        2.0G`;
  if (c === "top" || c === "htop") return `[Interactive process viewer - simulated]\nPID   USER     PR  NI    VIRT    RES    SHR S  %CPU  %MEM     TIME+ COMMAND\n1234 ${user}  20   0  567m  124m   18m S   2.3   1.6  12:34.56 node\n5678 ${user}  20   0  456m   89m   12m S   1.1   1.1   8:23.12 python3\n   1 root     20   0  168m  14.2m  8.9m S   0.0   0.2   0:12.34 systemd`;
  if (c.startsWith("cat ")) return `[Contents of ${c.slice(4)}]\n# Simulated file content\necho "Hello from ${host}"`;
  if (c.startsWith("echo ")) return c.slice(5).replace(/['"]/g, "");
  if (c.startsWith("mkdir ")) return "";
  if (c.startsWith("touch ")) return "";
  if (c.startsWith("rm ")) return `removed '${c.split(" ")[1]}'`;
  if (c.startsWith("grep ")) return `[Simulated grep results for: ${c.slice(5)}]`;
  if (c.startsWith("ping ")) {
    const target = c.split(" ").slice(-1)[0];
    return `PING ${target}: 56 data bytes\n64 bytes from ${target}: icmp_seq=0 ttl=64 time=1.23 ms\n64 bytes from ${target}: icmp_seq=1 ttl=64 time=0.98 ms\n64 bytes from ${target}: icmp_seq=2 ttl=64 time=1.05 ms\n--- ${target} ping statistics ---\n3 packets transmitted, 3 received, 0% packet loss`;
  }
  if (c === "ifconfig" || c === "ip addr") return `eth0: flags=4163<UP,BROADCAST,RUNNING,MULTICAST>  mtu 1500\n  inet ${host}  netmask 255.255.255.0  broadcast 192.168.1.255\n  ether 02:42:ac:11:00:02  txqueuelen 0  (Ethernet)\nlo: flags=73<UP,LOOPBACK,RUNNING>  mtu 65536\n  inet 127.0.0.1  netmask 255.0.0.0`;
  if (c === "netstat -tlnp" || c === "ss -tlnp") return `State   Recv-Q Send-Q Local Address:Port  Peer Address:Port\nLISTEN  0      128    0.0.0.0:22         0.0.0.0:*\nLISTEN  0      128    0.0.0.0:80         0.0.0.0:*\nLISTEN  0      128    0.0.0.0:443        0.0.0.0:*\nLISTEN  0      128    127.0.0.1:5432     0.0.0.0:*`;
  if (c === "ps aux") return `USER         PID %CPU %MEM    VSZ   RSS TTY      STAT START   TIME COMMAND\nroot           1  0.0  0.2 168536 14200 ?        Ss   Jan01   0:12 /sbin/init\n${user}      1234  2.3  1.6 581048 127744 ?       Sl   07:30  12:34 node server.js\n${user}      5678  1.1  1.1 467776  91234 ?       S    08:00   8:23 python3 app.py`;
  if (c === "history") return `    1  ls -la\n    2  cd projects\n    3  git status\n    4  git pull\n    5  npm install\n    6  node server.js\n    7  ps aux\n    8  df -h`;
  if (c === "exit") return "\x1B[Session closed]";
  if (c.startsWith("ssh ")) return `[Simulated nested SSH → ${c.slice(4)}]`;
  if (c === "clear" || c === "cls") return "\x1Bclear";
  if (c === "help" || c === "?") return `Available commands (simulated):\n  ls, ls -la       List directory contents\n  pwd              Print working directory\n  cd <dir>         Change directory\n  cat <file>       Show file contents\n  echo <text>      Print text\n  mkdir / touch    Create dir / file\n  rm <file>        Remove file\n  grep             Search text\n  ping <host>      Ping a host\n  ps aux           Process list\n  top / htop       Process viewer\n  ifconfig         Network interfaces\n  netstat -tlnp    Open ports\n  date             Current date/time\n  uptime           System uptime\n  df -h            Disk usage\n  free -h          Memory info\n  history          Command history\n  clear / cls      Clear screen\n  exit             Close session`;
  return `\x1B[31mbash: ${c.split(" ")[0]}: command not found\x1B[0m`;
};

// ─── File tree helpers ─────────────────────────────────────────────────────
const getFileIcon = (name) => {
  if (name.endsWith(".sh"))                    return "📜";
  if (name.endsWith(".md"))                    return "📝";
  if (name.endsWith(".json"))                  return "📋";
  if (name.endsWith(".log"))                   return "📃";
  if (name.endsWith(".conf") || name.endsWith(".cfg")) return "⚙️";
  if (name.endsWith(".pub"))                   return "🔑";
  if (name.startsWith("."))                    return "🔒";
  return "📄";
};

const FileNode = ({ node, depth = 0, onToggle }) => {
  const isDir = node.type === "dir";
  return (
    <div>
      <div className="file-node" style={{ paddingLeft: `${8 + depth * 14}px` }} onClick={() => isDir && onToggle(node)}>
        {isDir && (
          <span className="chevron" style={{ opacity: node.children?.length ? 1 : 0.3 }}>
            {node.expanded ? "▾" : "▸"}
          </span>
        )}
        <span className="file-icon">{isDir ? (node.expanded ? "📂" : "📁") : getFileIcon(node.name)}</span>
        <span className="file-name">{node.name}</span>
        {!isDir && <span className="file-size">{node.size}</span>}
      </div>
      {isDir && node.expanded && node.children?.map((child, i) => (
        <FileNode key={i} node={child} depth={depth + 1} onToggle={onToggle} />
      ))}
    </div>
  );
};

// ─── Context Menu ──────────────────────────────────────────────────────────
const ContextMenu = ({ x, y, session, onClose, onConnect, onDuplicate, onRename, onDelete }) => {
  const ref = useRef(null);
  useEffect(() => {
    const handleClick = (e) => { if (ref.current && !ref.current.contains(e.target)) onClose(); };
    document.addEventListener("mousedown", handleClick);
    return () => document.removeEventListener("mousedown", handleClick);
  }, [onClose]);

  const items = [
    { icon: "▶", label: "Connect",   action: onConnect,   color: "#60a5fa" },
    { icon: "⧉", label: "Duplicate", action: onDuplicate, color: "#8899bb" },
    { icon: "✎", label: "Rename",    action: onRename,    color: "#8899bb" },
    { divider: true },
    { icon: "🗑", label: "Delete",   action: onDelete,    color: "#f87171" },
  ];

  return (
    <div ref={ref} className="ctx-menu" style={{ top: y, left: x }}>
      {items.map((item, i) =>
        item.divider ? <div key={i} className="ctx-divider" /> : (
          <div key={i} className="ctx-item" style={{ color: item.color }} onClick={() => { item.action(); onClose(); }}>
            <span className="ctx-icon">{item.icon}</span>
            {item.label}
          </div>
        )
      )}
    </div>
  );
};

// ─── New Session Modal (with key auth) ────────────────────────────────────
const NewSessionModal = ({ onClose, onConnect, initial }) => {
  const [form, setForm] = useState({
    name: "", host: "", port: "22", user: "root",
    password: "", keyPath: "", authType: "password", type: "ssh",
    ...initial
  });
  const set = (k, v) => setForm(f => ({ ...f, [k]: v }));

  const handleSubmit = () => {
    if (!form.host && form.type !== "local") return;
    onConnect({
      id: initial?.id || "s" + Date.now(),
      name: form.name || form.host || "Local Terminal",
      type: form.type,
      host: form.type === "local" ? "localhost" : form.host,
      port: parseInt(form.port) || 22,
      user: form.user || "user",
      authType: form.authType,
      keyPath: form.keyPath,
      color: initial?.color || "#" + Math.floor(Math.random() * 0xffffff).toString(16).padStart(6, "0"),
    });
    onClose();
  };

  const typeDefaults = { ssh: "22", rdp: "3389", vnc: "5900", ftp: "21", local: "" };

  return (
    <div className="modal-overlay" onClick={onClose}>
      <div className="modal" onClick={e => e.stopPropagation()}>
        <div className="modal-header">
          <span>{initial ? "Edit Session" : "New Session"}</span>
          <button className="modal-close" onClick={onClose}>✕</button>
        </div>
        <div className="modal-body">
          <div className="modal-tabs">
            {["ssh","rdp","vnc","ftp","local"].map(t => (
              <button key={t} className={`modal-tab ${form.type === t ? "active" : ""}`}
                onClick={() => set("type", t) || set("port", typeDefaults[t])}>
                {t.toUpperCase()}
              </button>
            ))}
          </div>
          <div className="form-grid">
            <label>Session Name</label>
            <input placeholder={form.type === "local" ? "Local Terminal" : "Optional"} value={form.name} onChange={e => set("name", e.target.value)} />
            {form.type !== "local" && <>
              <label>Host / IP</label>
              <input placeholder="192.168.1.100" value={form.host} onChange={e => set("host", e.target.value)} />
              <label>Port</label>
              <input type="number" value={form.port} onChange={e => set("port", e.target.value)} />
            </>}
            <label>Username</label>
            <input value={form.user} onChange={e => set("user", e.target.value)} />
            {form.type === "ssh" && <>
              <label>Auth</label>
              <div style={{ display: "flex", gap: 8 }}>
                {["password","key"].map(t => (
                  <label key={t} style={{ display:"flex", alignItems:"center", gap:4, cursor:"pointer", fontSize:12, color: form.authType===t?"#60a5fa":"#4a5f88" }}>
                    <input type="radio" checked={form.authType===t} onChange={() => set("authType", t)} style={{ accentColor:"#3b82f6" }} />
                    {t === "password" ? "Password" : "SSH Key"}
                  </label>
                ))}
              </div>
              {form.authType === "password" ? (
                <>
                  <label>Password</label>
                  <input type="password" placeholder="Leave blank for prompt" value={form.password} onChange={e => set("password", e.target.value)} />
                </>
              ) : (
                <>
                  <label>Key File</label>
                  <input placeholder="~/.ssh/id_ed25519" value={form.keyPath} onChange={e => set("keyPath", e.target.value)} />
                </>
              )}
            </>}
            {form.type !== "ssh" && form.type !== "local" && <>
              <label>Password</label>
              <input type="password" placeholder="Optional" value={form.password} onChange={e => set("password", e.target.value)} />
            </>}
          </div>
        </div>
        <div className="modal-footer">
          <button className="btn-cancel" onClick={onClose}>Cancel</button>
          <button className="btn-connect" onClick={handleSubmit}>{initial ? "Save" : "Connect"}</button>
        </div>
      </div>
    </div>
  );
};

// ─── Settings Modal ────────────────────────────────────────────────────────
const SettingsModal = ({ settings, onChange, onClose }) => {
  const [local, setLocal] = useState(settings);
  const set = (k, v) => setLocal(s => ({ ...s, [k]: v }));
  const apply = () => { onChange(local); onClose(); };

  return (
    <div className="modal-overlay" onClick={onClose}>
      <div className="modal" style={{ width: 520 }} onClick={e => e.stopPropagation()}>
        <div className="modal-header"><span>⚙️ Settings</span><button className="modal-close" onClick={onClose}>✕</button></div>
        <div className="modal-body">
          <div className="settings-section">
            <div className="settings-title">Terminal</div>
            <div className="form-grid">
              <label>Font Size</label>
              <div style={{ display:"flex", alignItems:"center", gap:10 }}>
                <input type="range" min="10" max="18" value={local.fontSize} onChange={e => set("fontSize", +e.target.value)} style={{ flex:1, accentColor:"#3b82f6" }} />
                <span style={{ color:"#8899bb", fontSize:12, minWidth:30 }}>{local.fontSize}px</span>
              </div>
              <label>Font Family</label>
              <select value={local.fontFamily} onChange={e => set("fontFamily", e.target.value)}
                style={{ background:"#080c18", border:"1px solid #1e2a45", borderRadius:5, padding:"6px 10px", fontSize:12, color:"#c8d3e8", outline:"none" }}>
                {["JetBrains Mono","Fira Code","Cascadia Code","Courier New","Menlo","Monaco"].map(f => (
                  <option key={f} value={f}>{f}</option>
                ))}
              </select>
              <label>Line Height</label>
              <div style={{ display:"flex", alignItems:"center", gap:10 }}>
                <input type="range" min="1.2" max="2.0" step="0.1" value={local.lineHeight} onChange={e => set("lineHeight", +e.target.value)} style={{ flex:1, accentColor:"#3b82f6" }} />
                <span style={{ color:"#8899bb", fontSize:12, minWidth:30 }}>{local.lineHeight}</span>
              </div>
              <label>Cursor</label>
              <div style={{ display:"flex", gap:8 }}>
                {["block","underline","bar"].map(c => (
                  <label key={c} style={{ display:"flex", alignItems:"center", gap:4, cursor:"pointer", fontSize:12, color: local.cursor===c?"#60a5fa":"#4a5f88", textTransform:"capitalize" }}>
                    <input type="radio" checked={local.cursor===c} onChange={() => set("cursor", c)} style={{ accentColor:"#3b82f6" }} />
                    {c}
                  </label>
                ))}
              </div>
              <label>Scrollback</label>
              <input type="number" value={local.scrollback} min={100} max={10000} step={100}
                onChange={e => set("scrollback", +e.target.value)}
                style={{ background:"#080c18", border:"1px solid #1e2a45", borderRadius:5, padding:"6px 10px", fontSize:12, color:"#c8d3e8", outline:"none" }} />
            </div>
          </div>
          <div className="settings-section" style={{ marginTop:16 }}>
            <div className="settings-title">Appearance</div>
            <div className="form-grid">
              <label>Theme</label>
              <div style={{ display:"flex", gap:8 }}>
                {[{id:"dark",label:"Dark"},{id:"darker",label:"Darker"},{id:"monokai",label:"Monokai"}].map(t => (
                  <label key={t.id} style={{ display:"flex", alignItems:"center", gap:4, cursor:"pointer", fontSize:12, color: local.theme===t.id?"#60a5fa":"#4a5f88" }}>
                    <input type="radio" checked={local.theme===t.id} onChange={() => set("theme", t.id)} style={{ accentColor:"#3b82f6" }} />
                    {t.label}
                  </label>
                ))}
              </div>
              <label>Bell</label>
              <label style={{ display:"flex", alignItems:"center", gap:6, cursor:"pointer" }}>
                <input type="checkbox" checked={local.bell} onChange={e => set("bell", e.target.checked)} style={{ accentColor:"#3b82f6" }} />
                <span style={{ fontSize:12, color:"#8899bb" }}>Enable terminal bell</span>
              </label>
            </div>
          </div>
          <div className="settings-section" style={{ marginTop:16 }}>
            <div className="settings-title">Connection</div>
            <div className="form-grid">
              <label>Keep-alive</label>
              <div style={{ display:"flex", alignItems:"center", gap:10 }}>
                <input type="range" min={0} max={120} step={5} value={local.keepalive}
                  onChange={e => set("keepalive", +e.target.value)} style={{ flex:1, accentColor:"#3b82f6" }} />
                <span style={{ color:"#8899bb", fontSize:12, minWidth:50 }}>{local.keepalive === 0 ? "Off" : `${local.keepalive}s`}</span>
              </div>
              <label>Timeout</label>
              <div style={{ display:"flex", alignItems:"center", gap:10 }}>
                <input type="range" min={5} max={120} step={5} value={local.timeout}
                  onChange={e => set("timeout", +e.target.value)} style={{ flex:1, accentColor:"#3b82f6" }} />
                <span style={{ color:"#8899bb", fontSize:12, minWidth:50 }}>{local.timeout}s</span>
              </div>
            </div>
          </div>
        </div>
        <div className="modal-footer">
          <button className="btn-cancel" onClick={onClose}>Cancel</button>
          <button className="btn-connect" onClick={apply}>Apply</button>
        </div>
      </div>
    </div>
  );
};

// ─── Tunnel Modal ──────────────────────────────────────────────────────────
const TunnelModal = ({ tunnels, onAdd, onDelete, onClose }) => {
  const [form, setForm] = useState({ name:"", localPort:"", remoteHost:"", remotePort:"", server:"", user:"root", type:"L" });
  const set = (k, v) => setForm(f => ({ ...f, [k]: v }));
  const handleAdd = () => {
    if (!form.localPort || !form.remoteHost || !form.server) return;
    onAdd({ ...form, id: "t" + Date.now(), active: true });
    setForm({ name:"", localPort:"", remoteHost:"", remotePort:"", server:"", user:"root", type:"L" });
  };

  return (
    <div className="modal-overlay" onClick={onClose}>
      <div className="modal" style={{ width:580 }} onClick={e => e.stopPropagation()}>
        <div className="modal-header"><span>🔧 Port Tunnels</span><button className="modal-close" onClick={onClose}>✕</button></div>
        <div className="modal-body">
          <div className="settings-title" style={{ marginBottom:10 }}>Active Tunnels</div>
          {tunnels.length === 0
            ? <div style={{ color:"#2a3a58", fontSize:12, padding:"10px 0", textAlign:"center" }}>No active tunnels</div>
            : tunnels.map(t => (
              <div key={t.id} className="tunnel-row">
                <div className={`status-dot ${t.active ? "" : "off"}`} style={{ width:7, height:7, borderRadius:"50%", flexShrink:0 }} />
                <div style={{ flex:1 }}>
                  <div style={{ color:"#8899bb", fontSize:11, fontWeight:600 }}>{t.name || `Tunnel ${t.localPort}`}</div>
                  <div style={{ color:"#3d5a8a", fontSize:10, fontFamily:"monospace" }}>
                    localhost:{t.localPort} → {t.remoteHost}:{t.remotePort} via {t.user}@{t.server}
                  </div>
                </div>
                <button style={{ background:"none", border:"none", color:"#f87171", cursor:"pointer", fontSize:14, padding:"2px 6px" }}
                  onClick={() => onDelete(t.id)}>✕</button>
              </div>
            ))
          }
          <div className="settings-title" style={{ margin:"16px 0 10px" }}>New Tunnel</div>
          <div style={{ display:"flex", gap:6, marginBottom:8 }}>
            {[{id:"L",label:"Local (-L)"},{id:"R",label:"Remote (-R)"},{id:"D",label:"Dynamic (-D)"}].map(t => (
              <button key={t.id} className={`modal-tab ${form.type===t.id?"active":""}`} onClick={() => set("type", t.id)}>{t.label}</button>
            ))}
          </div>
          <div className="form-grid">
            <label>Name</label>
            <input placeholder="My Tunnel" value={form.name} onChange={e => set("name", e.target.value)} />
            <label>Local Port</label>
            <input type="number" placeholder="8080" value={form.localPort} onChange={e => set("localPort", e.target.value)} />
            {form.type !== "D" && <>
              <label>Remote Host</label>
              <input placeholder="localhost" value={form.remoteHost} onChange={e => set("remoteHost", e.target.value)} />
              <label>Remote Port</label>
              <input type="number" placeholder="3306" value={form.remotePort} onChange={e => set("remotePort", e.target.value)} />
            </>}
            <label>SSH Server</label>
            <input placeholder="user@host" value={form.server} onChange={e => set("server", e.target.value)} />
          </div>
        </div>
        <div className="modal-footer">
          <button className="btn-cancel" onClick={onClose}>Close</button>
          <button className="btn-connect" onClick={handleAdd}>+ Add Tunnel</button>
        </div>
      </div>
    </div>
  );
};

// ─── Keys Modal ────────────────────────────────────────────────────────────
const KeysModal = ({ keys, onAdd, onDelete, onClose }) => {
  const [showAdd, setShowAdd] = useState(false);
  const [form, setForm] = useState({ name:"", path:"", passphrase:"" });
  const set = (k, v) => setForm(f => ({ ...f, [k]: v }));
  const handleAdd = () => {
    if (!form.name || !form.path) return;
    onAdd({ ...form, id: "k" + Date.now(), type: "ed25519", added: new Date().toLocaleDateString(), fingerprint: "SHA256:..." });
    setForm({ name:"", path:"", passphrase:"" });
    setShowAdd(false);
  };

  return (
    <div className="modal-overlay" onClick={onClose}>
      <div className="modal" style={{ width:540 }} onClick={e => e.stopPropagation()}>
        <div className="modal-header"><span>🔑 SSH Key Manager</span><button className="modal-close" onClick={onClose}>✕</button></div>
        <div className="modal-body">
          {keys.map(k => (
            <div key={k.id} className="key-row">
              <div style={{ fontSize:22 }}>🔑</div>
              <div style={{ flex:1 }}>
                <div style={{ color:"#8899bb", fontSize:12, fontWeight:600 }}>{k.name}</div>
                <div style={{ color:"#3d5a8a", fontSize:10, fontFamily:"monospace" }}>{k.path}</div>
                <div style={{ color:"#2a3a58", fontSize:10, marginTop:2 }}>{k.type} · Added {k.added} · {k.fingerprint}</div>
              </div>
              <button style={{ background:"none", border:"none", color:"#f87171", cursor:"pointer", fontSize:14, padding:"2px 6px" }}
                onClick={() => onDelete(k.id)}>✕</button>
            </div>
          ))}
          {keys.length === 0 && <div style={{ color:"#2a3a58", fontSize:12, padding:"10px 0", textAlign:"center" }}>No keys added</div>}
          {showAdd && (
            <div style={{ marginTop:16, padding:"14px", background:"#080c18", borderRadius:8, border:"1px solid #1a2035" }}>
              <div className="settings-title" style={{ marginBottom:10 }}>Add Key</div>
              <div className="form-grid">
                <label>Name</label>
                <input placeholder="My Key" value={form.name} onChange={e => set("name", e.target.value)} />
                <label>Path</label>
                <input placeholder="~/.ssh/id_ed25519" value={form.path} onChange={e => set("path", e.target.value)} />
                <label>Passphrase</label>
                <input type="password" placeholder="Leave blank if none" value={form.passphrase} onChange={e => set("passphrase", e.target.value)} />
              </div>
              <div style={{ display:"flex", gap:8, marginTop:12 }}>
                <button className="btn-cancel" onClick={() => setShowAdd(false)}>Cancel</button>
                <button className="btn-connect" onClick={handleAdd}>Add Key</button>
              </div>
            </div>
          )}
        </div>
        <div className="modal-footer">
          <button className="btn-cancel" onClick={onClose}>Close</button>
          <button className="btn-connect" onClick={() => setShowAdd(true)}>+ Add Key</button>
        </div>
      </div>
    </div>
  );
};

// ─── Keyboard Shortcuts Modal ──────────────────────────────────────────────
const ShortcutsModal = ({ onClose }) => {
  const shortcuts = [
    { keys:"⌘ N",    desc:"New session" },
    { keys:"⌘ T",    desc:"New local terminal" },
    { keys:"⌘ W",    desc:"Close current tab" },
    { keys:"⌘ K",    desc:"Clear terminal" },
    { keys:"⌘ B",    desc:"Toggle SFTP panel" },
    { keys:"⌘ \\",   desc:"Toggle sidebar" },
    { keys:"⌘ 1-9",  desc:"Switch to tab 1–9" },
    { keys:"⌘ Tab",  desc:"Next tab" },
    { keys:"⌃ L",    desc:"Clear screen (terminal)" },
    { keys:"↑ / ↓",  desc:"Navigate command history" },
    { keys:"⌃ C",    desc:"Interrupt current command" },
  ];
  return (
    <div className="modal-overlay" onClick={onClose}>
      <div className="modal" style={{ width:420 }} onClick={e => e.stopPropagation()}>
        <div className="modal-header"><span>⌨️ Keyboard Shortcuts</span><button className="modal-close" onClick={onClose}>✕</button></div>
        <div className="modal-body">
          {shortcuts.map((s, i) => (
            <div key={i} style={{ display:"flex", justifyContent:"space-between", alignItems:"center", padding:"6px 0", borderBottom:"1px solid #141c30" }}>
              <span style={{ color:"#8899bb", fontSize:12 }}>{s.desc}</span>
              <kbd style={{ background:"#111827", border:"1px solid #1e2a45", borderRadius:4, padding:"2px 8px", fontSize:11, color:"#60a5fa", fontFamily:"inherit" }}>{s.keys}</kbd>
            </div>
          ))}
        </div>
        <div className="modal-footer"><button className="btn-connect" onClick={onClose}>Close</button></div>
      </div>
    </div>
  );
};

// ─── About Modal ───────────────────────────────────────────────────────────
const AboutModal = ({ onClose }) => (
  <div className="modal-overlay" onClick={onClose}>
    <div className="modal" style={{ width:360 }} onClick={e => e.stopPropagation()}>
      <div className="modal-header"><span>About</span><button className="modal-close" onClick={onClose}>✕</button></div>
      <div className="modal-body" style={{ textAlign:"center", padding:"24px 16px" }}>
        <div style={{ fontSize:56, marginBottom:12 }}>⚡</div>
        <div style={{ color:"#c8d3e8", fontSize:18, fontWeight:700, marginBottom:4 }}>MobaXterm for Mac</div>
        <div style={{ color:"#4a5f88", fontSize:12, marginBottom:16 }}>Version 1.0.0</div>
        <div style={{ color:"#3d5a8a", fontSize:11, lineHeight:1.8 }}>
          A feature-rich SSH terminal client<br />
          inspired by MobaXterm, built for macOS.<br /><br />
          Supports SSH, RDP, VNC, FTP sessions<br />
          with integrated SFTP browser.
        </div>
      </div>
      <div className="modal-footer"><button className="btn-connect" onClick={onClose}>Close</button></div>
    </div>
  </div>
);

// ─── Notepad Panel ─────────────────────────────────────────────────────────
const NotepadPanel = ({ content, onChange, onClose }) => (
  <div className="notepad-panel">
    <div className="sftp-header">
      <span>📝 Notepad</span>
      <button className="modal-close" onClick={onClose}>✕</button>
    </div>
    <div style={{ padding:"6px 8px", borderBottom:"1px solid #141c30", background:"#0d1120", display:"flex", gap:4 }}>
      {["B","I","U"].map(f => (
        <button key={f} style={{ background:"transparent", border:"1px solid #1e2640", borderRadius:3, color:"#3d5a8a", cursor:"pointer", fontSize:11, fontWeight:"bold", padding:"2px 7px" }}
          title={f === "B" ? "Bold" : f === "I" ? "Italic" : "Underline"}>{f}</button>
      ))}
    </div>
    <textarea
      className="notepad-textarea"
      value={content}
      onChange={e => onChange(e.target.value)}
      placeholder="Scratch pad — type your notes here..."
      spellCheck={false}
    />
    <div style={{ padding:"4px 10px", background:"#0d1120", borderTop:"1px solid #141c30", fontSize:9, color:"#2a3a58", display:"flex", justifyContent:"space-between" }}>
      <span>{content.split("\n").length} lines</span>
      <span>{content.length} chars</span>
    </div>
  </div>
);

// ─── Terminal ──────────────────────────────────────────────────────────────
const Terminal = ({ session, settings, onClear }) => {
  const [lines, setLines]     = useState([]);
  const [input, setInput]     = useState("");
  const [history, setHistory] = useState([]);
  const [histIdx, setHistIdx] = useState(-1);
  const inputRef = useRef(null);
  const bottomRef = useRef(null);

  useEffect(() => {
    const banner = [
      `\x1B[36m╔══════════════════════════════════════════════════╗\x1B[0m`,
      `\x1B[36m║  \x1B[33mMobaXterm for Mac\x1B[36m  –  SSH Terminal Emulator     ║\x1B[0m`,
      `\x1B[36m╚══════════════════════════════════════════════════╝\x1B[0m`,
      ``,
      session.type === "local"
        ? `\x1B[32mOpening local terminal...\x1B[0m`
        : `\x1B[32mConnecting to ${session.host}:${session.port} as ${session.user}...\x1B[0m`,
      `\x1B[32mAuthentication successful!\x1B[0m`,
      ``,
      session.type === "local"
        ? `Welcome to macOS local shell`
        : `Welcome to Ubuntu 22.04.5 LTS (GNU/Linux 6.1.0-28-amd64 x86_64)`,
      ``,
      `  System information as of ${new Date().toUTCString()}`,
      `  System load:  0.08              Users logged in: 1`,
      `  Usage of /:   56.0% of 79.36GB  Processes:       142`,
      `  Memory usage: 27%               IPv4 address:    ${session.host}`,
      ``,
      `Type \x1B[33mhelp\x1B[0m to see available demo commands.`,
      ``,
    ];
    setLines(banner.map((text, i) => ({ id: i, text, type: "output" })));
  }, [session.id]);

  useEffect(() => {
    bottomRef.current?.scrollIntoView({ behavior: "smooth" });
  }, [lines]);

  useEffect(() => {
    if (onClear) { setLines([]); }
  }, [onClear]);

  const handleKey = (e) => {
    if (e.key === "Enter") {
      const cmd = input.trim();
      const ts = Date.now();
      if (cmd === "clear" || cmd === "cls") {
        setLines([]);
      } else {
        const newLines = [...lines, { id: ts, text: `${session.user}@${session.host}:~$ ${cmd}`, type: "input" }];
        const out = simulateCommand(cmd, session.host, session.user);
        if (out && out !== "\x1Bclear") newLines.push({ id: ts + 1, text: out, type: "output" });
        setLines(newLines);
      }
      if (cmd) setHistory(h => [cmd, ...h.slice(0, 49)]);
      setHistIdx(-1);
      setInput("");
    } else if (e.key === "ArrowUp") {
      e.preventDefault();
      setHistIdx(i => { const next = Math.min(i+1, history.length-1); setInput(history[next] || ""); return next; });
    } else if (e.key === "ArrowDown") {
      e.preventDefault();
      setHistIdx(i => { const next = Math.max(i-1, -1); setInput(next === -1 ? "" : history[next]); return next; });
    } else if (e.key === "l" && e.ctrlKey) {
      e.preventDefault(); setLines([]);
    } else if (e.key === "c" && e.ctrlKey) {
      e.preventDefault();
      setLines(l => [...l, { id: Date.now(), text: `${session.user}@${session.host}:~$ ${input}^C`, type:"input" }]);
      setInput("");
    }
  };

  const renderAnsi = (text) => {
    const parts = text.split(/(\x1B\[[0-9;]*m)/);
    let style = {};
    return parts.map((part, i) => {
      const m = part.match(/\x1B\[([0-9;]*)m/);
      if (m) {
        const code = m[1];
        if (code === "0" || code === "") style = {};
        else if (code === "32") style = { color: "#4ade80" };
        else if (code === "33") style = { color: "#fbbf24" };
        else if (code === "34") style = { color: "#60a5fa" };
        else if (code === "36") style = { color: "#22d3ee" };
        else if (code === "31") style = { color: "#f87171" };
        else if (code === "35") style = { color: "#c084fc" };
        return null;
      }
      return <span key={i} style={style}>{part}</span>;
    });
  };

  const fontStyle = {
    fontFamily: `'${settings.fontFamily}', 'JetBrains Mono', monospace`,
    fontSize: settings.fontSize,
    lineHeight: settings.lineHeight,
  };

  return (
    <div className="terminal" style={fontStyle} onClick={() => inputRef.current?.focus()}>
      <div className="terminal-output">
        {lines.map(line => (
          <div key={line.id} className={`term-line ${line.type}`}>{renderAnsi(line.text)}</div>
        ))}
        <div className="term-input-row">
          <span className="term-prompt" style={fontStyle}>
            <span style={{ color:"#4ade80" }}>{session.user}@{session.host}</span>
            <span style={{ color:"#94a3b8" }}>:</span>
            <span style={{ color:"#60a5fa" }}>~</span>
            <span style={{ color:"#e2e8f0" }}>$ </span>
          </span>
          <input ref={inputRef} className="term-input" style={fontStyle}
            value={input} onChange={e => setInput(e.target.value)}
            onKeyDown={handleKey} autoFocus spellCheck={false} autoComplete="off" />
        </div>
        <div ref={bottomRef} />
      </div>
    </div>
  );
};

// ─── Main App ──────────────────────────────────────────────────────────────
export default function App() {
  const [sessions,        setSessions]        = useState(defaultSessions);
  const [tabs,            setTabs]            = useState([]);
  const [activeTab,       setActiveTab]       = useState(null);
  const [showModal,       setShowModal]       = useState(false);
  const [editSession,     setEditSession]     = useState(null);
  const [showSFTP,        setShowSFTP]        = useState(false);
  const [showNotepad,     setShowNotepad]     = useState(false);
  const [showSettings,    setShowSettings]    = useState(false);
  const [showTunnel,      setShowTunnel]      = useState(false);
  const [showKeys,        setShowKeys]        = useState(false);
  const [showShortcuts,   setShowShortcuts]   = useState(false);
  const [showAbout,       setShowAbout]       = useState(false);
  const [fileTree,        setFileTree]        = useState(mockFileTree);
  const [sidebarWidth,    setSidebarWidth]    = useState(220);
  const [showSidebar,     setShowSidebar]     = useState(true);
  const [dragging,        setDragging]        = useState(false);
  const [selectedSession, setSelectedSession] = useState(null);
  const [expandedGroups,  setExpandedGroups]  = useState({ g1:true, g2:true, g3:true });
  const [searchQuery,     setSearchQuery]     = useState("");
  const [contextMenu,     setContextMenu]     = useState(null);
  const [renamingId,      setRenamingId]      = useState(null);
  const [renameVal,       setRenameVal]       = useState("");
  const [activeMenu,      setActiveMenu]      = useState(null);
  const [notepadContent,  setNotepadContent]  = useState("");
  const [sshKeys,         setSshKeys]         = useState(defaultSshKeys);
  const [tunnels,         setTunnels]         = useState([]);
  const [clearSignal,     setClearSignal]     = useState(0);
  const [settings, setSettings] = useState({
    fontSize: 12.5, fontFamily: "JetBrains Mono", lineHeight: 1.55,
    cursor: "block", scrollback: 1000, bell: false, theme: "dark",
    keepalive: 30, timeout: 30,
  });

  const menuRef = useRef(null);
  const renameRef = useRef(null);

  // ── Derived: filtered sessions ──────────────────────────────────────────
  const filteredSessions = sessions.map(group => ({
    ...group,
    children: group.children.filter(s =>
      s.name.toLowerCase().includes(searchQuery.toLowerCase()) ||
      s.host.toLowerCase().includes(searchQuery.toLowerCase()) ||
      s.user.toLowerCase().includes(searchQuery.toLowerCase())
    )
  })).filter(group => searchQuery === "" || group.children.length > 0);

  // ── Tab & session ops ────────────────────────────────────────────────────
  const openSession = useCallback((sess) => {
    const existing = tabs.find(t => t.id === sess.id);
    if (existing) { setActiveTab(existing.tabId); return; }
    const newTab = { ...sess, tabId: sess.id + "_" + Date.now() };
    setTabs(t => [...t, newTab]);
    setActiveTab(newTab.tabId);
    setShowSFTP(sess.type !== "local");
  }, [tabs]);

  const closeTab = (tabId, e) => {
    e?.stopPropagation();
    setTabs(t => {
      const remaining = t.filter(x => x.tabId !== tabId);
      if (activeTab === tabId) setActiveTab(remaining[remaining.length - 1]?.tabId || null);
      if (remaining.length === 0) setShowSFTP(false);
      return remaining;
    });
  };

  const openLocalTerminal = () => {
    const id = "local_" + Date.now();
    const localSess = { id, name:"Local Terminal", type:"local", host:"localhost", port:22, user:"user", color:"#34d399" };
    openSession(localSess);
  };

  const addNewSession = (sess) => {
    // Add to sidebar under a "Saved" group if it's a real remote
    if (sess.type !== "local") {
      setSessions(s => {
        const savedGroup = s.find(g => g.id === "g_saved");
        if (savedGroup) {
          return s.map(g => g.id === "g_saved" ? { ...g, children: [...g.children, sess] } : g);
        }
        return [...s, { id:"g_saved", name:"Saved", type:"group", expanded:true, children:[sess] }];
      });
    }
    openSession(sess);
  };

  const saveEditSession = (updated) => {
    setSessions(s => s.map(g => ({
      ...g, children: g.children.map(c => c.id === updated.id ? { ...c, ...updated } : c)
    })));
    // Update open tab if present
    setTabs(t => t.map(tab => tab.id === updated.id ? { ...tab, ...updated } : tab));
  };

  const duplicateSession = (sess) => {
    const dup = { ...sess, id:"s" + Date.now(), name: sess.name + " (copy)", color:"#" + Math.floor(Math.random()*0xffffff).toString(16).padStart(6,"0") };
    setSessions(s => s.map(g => ({
      ...g, children: g.children.find(c => c.id === sess.id)
        ? [...g.children, dup] : g.children
    })));
  };

  const deleteSession = (sessId) => {
    setSessions(s => s.map(g => ({ ...g, children: g.children.filter(c => c.id !== sessId) }))
      .filter(g => g.children.length > 0 || !g.id.startsWith("g_saved")));
    const tab = tabs.find(t => t.id === sessId);
    if (tab) closeTab(tab.tabId);
    if (selectedSession?.id === sessId) setSelectedSession(null);
  };

  const startRename = (sess) => {
    setRenamingId(sess.id);
    setRenameVal(sess.name);
    setTimeout(() => renameRef.current?.focus(), 50);
  };

  const commitRename = (sessId) => {
    if (renameVal.trim()) {
      setSessions(s => s.map(g => ({ ...g, children: g.children.map(c => c.id === sessId ? { ...c, name: renameVal.trim() } : c) })));
      setTabs(t => t.map(tab => tab.id === sessId ? { ...tab, name: renameVal.trim() } : tab));
    }
    setRenamingId(null);
  };

  // ── File tree ────────────────────────────────────────────────────────────
  const toggleFileNode = (targetNode) => {
    const toggle = (nodes) => nodes.map(n => {
      if (n === targetNode) return { ...n, expanded: !n.expanded };
      if (n.children) return { ...n, children: toggle(n.children) };
      return n;
    });
    setFileTree(toggle(fileTree));
  };

  const activeTabData = tabs.find(t => t.tabId === activeTab);

  // ── Sidebar drag ─────────────────────────────────────────────────────────
  const handleSidebarDrag = useCallback((e) => {
    if (dragging) setSidebarWidth(Math.max(160, Math.min(400, e.clientX)));
  }, [dragging]);

  useEffect(() => {
    if (dragging) {
      window.addEventListener("mousemove", handleSidebarDrag);
      window.addEventListener("mouseup", () => setDragging(false));
    }
    return () => { window.removeEventListener("mousemove", handleSidebarDrag); };
  }, [dragging, handleSidebarDrag]);

  // ── Keyboard shortcuts ───────────────────────────────────────────────────
  useEffect(() => {
    const handler = (e) => {
      if (e.metaKey || e.ctrlKey) {
        if (e.key === "n") { e.preventDefault(); setShowModal(true); }
        if (e.key === "t") { e.preventDefault(); openLocalTerminal(); }
        if (e.key === "w") { e.preventDefault(); if (activeTab) closeTab(activeTab); }
        if (e.key === "b") { e.preventDefault(); setShowSFTP(s => !s); }
        if (e.key === "\\") { e.preventDefault(); setShowSidebar(s => !s); }
        if (e.key === "k") { e.preventDefault(); setClearSignal(s => s + 1); }
        const num = parseInt(e.key);
        if (num >= 1 && num <= 9 && tabs[num - 1]) { e.preventDefault(); setActiveTab(tabs[num-1].tabId); }
        if (e.key === "Tab") { e.preventDefault();
          const idx = tabs.findIndex(t => t.tabId === activeTab);
          if (idx >= 0) setActiveTab(tabs[(idx + 1) % tabs.length].tabId);
        }
      }
    };
    window.addEventListener("keydown", handler);
    return () => window.removeEventListener("keydown", handler);
  }, [activeTab, tabs]);

  // ── Close menus on outside click ─────────────────────────────────────────
  useEffect(() => {
    const handler = (e) => {
      if (menuRef.current && !menuRef.current.contains(e.target)) setActiveMenu(null);
    };
    document.addEventListener("mousedown", handler);
    return () => document.removeEventListener("mousedown", handler);
  }, []);

  // ── Menu definitions ──────────────────────────────────────────────────────
  const menus = {
    Sessions: [
      { label:"New Session",         shortcut:"⌘N", action:() => setShowModal(true) },
      { label:"New Local Terminal",  shortcut:"⌘T", action:openLocalTerminal },
      { divider:true },
      { label:"Import Sessions",     action:() => {} },
      { label:"Export Sessions",     action:() => {} },
    ],
    Shell: [
      { label:"New Terminal",        shortcut:"⌘T", action:openLocalTerminal },
      { label:"Clear Terminal",      shortcut:"⌘K", action:() => setClearSignal(s => s + 1) },
      { divider:true },
      { label:"Close Tab",           shortcut:"⌘W", action:() => activeTab && closeTab(activeTab) },
    ],
    Tools: [
      { label:"Port Tunnels",        action:() => setShowTunnel(true) },
      { label:"SSH Key Manager",     action:() => setShowKeys(true) },
      { divider:true },
      { label:"Settings",            action:() => setShowSettings(true) },
    ],
    View: [
      { label:"Toggle Sidebar",      shortcut:"⌘\\",  action:() => setShowSidebar(s => !s) },
      { label:"Toggle SFTP Panel",   shortcut:"⌘B",   action:() => setShowSFTP(s => !s) },
      { label:"Toggle Notepad",      action:() => setShowNotepad(s => !s) },
    ],
    Help: [
      { label:"Keyboard Shortcuts",  action:() => setShowShortcuts(true) },
      { divider:true },
      { label:"About",               action:() => setShowAbout(true) },
    ],
  };

  return (
    <div className="app" onClick={() => setContextMenu(null)}>
      <style>{`
        @import url('https://fonts.googleapis.com/css2?family=JetBrains+Mono:wght@400;600&family=Inter:wght@400;500;600&display=swap');
        * { box-sizing:border-box; margin:0; padding:0; }
        body { background:#0a0e1a; }
        .app { font-family:'Inter',sans-serif; background:#0a0e1a; color:#c8d3e8; height:100vh; display:flex; flex-direction:column; overflow:hidden; user-select:none; }

        /* Titlebar */
        .titlebar { height:32px; background:#0d1120; display:flex; align-items:center; padding:0 12px; gap:8px; border-bottom:1px solid #1e2640; flex-shrink:0; }
        .traffic-lights { display:flex; gap:6px; align-items:center; }
        .tl { width:12px; height:12px; border-radius:50%; cursor:pointer; transition:filter 0.15s; }
        .tl:hover { filter:brightness(1.3); }
        .tl-red { background:#ff5f57; } .tl-yellow { background:#febc2e; } .tl-green { background:#28c840; }
        .titlebar-title { flex:1; text-align:center; font-size:12px; color:#4a5578; font-weight:500; letter-spacing:.5px; }

        /* Menubar */
        .menubar { height:28px; background:#111827; display:flex; align-items:center; padding:0 8px; gap:2px; border-bottom:1px solid #1e2640; flex-shrink:0; position:relative; z-index:200; }
        .menu-item { padding:3px 10px; font-size:12px; color:#8899bb; cursor:pointer; border-radius:4px; transition:all .15s; position:relative; }
        .menu-item:hover, .menu-item.open { background:#1e2a45; color:#c8d3e8; }
        .menu-dropdown { position:absolute; top:calc(100% + 2px); left:0; background:#0d1120; border:1px solid #1e2640; border-radius:6px; min-width:200px; padding:4px; box-shadow:0 12px 40px rgba(0,0,0,.7); z-index:300; }
        .menu-dd-item { display:flex; justify-content:space-between; align-items:center; padding:6px 12px; font-size:12px; color:#8899bb; cursor:pointer; border-radius:4px; transition:all .1s; }
        .menu-dd-item:hover { background:#1e2a45; color:#c8d3e8; }
        .menu-dd-shortcut { font-size:11px; color:#3d5a8a; }
        .menu-dd-divider { height:1px; background:#1a2035; margin:4px 0; }

        /* Toolbar */
        .toolbar { height:38px; background:#0f1628; display:flex; align-items:center; padding:0 10px; gap:2px; border-bottom:1px solid #1a2035; flex-shrink:0; }
        .tb-btn { display:flex; flex-direction:column; align-items:center; gap:2px; padding:4px 8px; cursor:pointer; border-radius:5px; transition:all .15s; border:none; background:transparent; color:#6b82aa; font-size:9px; min-width:42px; }
        .tb-btn:hover { background:#1e2a45; color:#60a5fa; }
        .tb-btn.active { background:#1a2f55; color:#60a5fa; }
        .tb-sep { width:1px; height:24px; background:#1e2640; margin:0 4px; }
        .tb-icon { font-size:16px; line-height:1; }

        /* Main layout */
        .main-layout { display:flex; flex:1; overflow:hidden; }

        /* Sidebar */
        .sidebar { background:#0d1120; border-right:1px solid #1a2035; display:flex; flex-direction:column; overflow:hidden; flex-shrink:0; }
        .sidebar-header { padding:8px 10px 6px; font-size:10px; font-weight:600; color:#3d4f72; letter-spacing:1.2px; text-transform:uppercase; display:flex; align-items:center; justify-content:space-between; border-bottom:1px solid #141c30; }
        .sidebar-search { padding:6px 8px; border-bottom:1px solid #141c30; }
        .sidebar-search input { width:100%; background:#111827; border:1px solid #1e2a45; border-radius:4px; padding:4px 8px 4px 24px; font-size:11px; color:#8899bb; outline:none; }
        .sidebar-search input:focus { border-color:#2d4a7a; }
        .search-wrap { position:relative; }
        .search-wrap::before { content:"🔍"; position:absolute; left:6px; top:50%; transform:translateY(-50%); font-size:10px; }
        .sidebar-scroll { flex:1; overflow-y:auto; padding:4px 0; }
        .sidebar-scroll::-webkit-scrollbar { width:4px; }
        .sidebar-scroll::-webkit-scrollbar-thumb { background:#1e2a45; border-radius:2px; }

        /* Session tree */
        .group-header { display:flex; align-items:center; gap:5px; padding:5px 8px 5px 6px; font-size:11px; font-weight:600; color:#4a5f88; cursor:pointer; user-select:none; }
        .group-header:hover { color:#6b82aa; }
        .group-arrow { font-size:9px; transition:transform .15s; }
        .group-arrow.open { transform:rotate(90deg); }
        .session-item { display:flex; align-items:center; gap:6px; padding:5px 8px 5px 24px; font-size:11px; color:#7a8fa8; cursor:pointer; border-radius:4px; margin:1px 4px; transition:all .15s; }
        .session-item:hover { background:#131d35; color:#a8bdd8; }
        .session-item.active { background:#1a2f55; color:#60a5fa; }
        .session-dot { width:7px; height:7px; border-radius:50%; flex-shrink:0; }
        .session-type-badge { margin-left:auto; font-size:8px; padding:1px 4px; border-radius:3px; background:#1a2240; color:#3d5a8a; letter-spacing:.5px; font-weight:600; }
        .rename-input { background:#111827; border:1px solid #3b82f6; border-radius:3px; color:#c8d3e8; font-size:11px; padding:1px 5px; outline:none; flex:1; font-family:inherit; }

        /* Resize handle */
        .resize-handle { width:4px; cursor:col-resize; background:transparent; transition:background .15s; flex-shrink:0; }
        .resize-handle:hover, .resize-handle.dragging { background:#2d4a7a; }

        /* Content area */
        .content-area { flex:1; display:flex; flex-direction:column; overflow:hidden; background:#080c18; }

        /* Tab bar */
        .tabbar { display:flex; align-items:center; background:#0d1120; border-bottom:1px solid #1a2035; min-height:34px; overflow-x:auto; flex-shrink:0; }
        .tabbar::-webkit-scrollbar { height:2px; }
        .tabbar::-webkit-scrollbar-thumb { background:#1e2a45; }
        .tab { display:flex; align-items:center; gap:6px; padding:6px 14px; font-size:11px; color:#556175; cursor:pointer; white-space:nowrap; border-right:1px solid #141c30; min-width:120px; transition:all .15s; position:relative; }
        .tab:hover { background:#111827; color:#8899bb; }
        .tab.active { background:#080c18; color:#c8d3e8; border-bottom:2px solid #3b82f6; }
        .tab-dot { width:6px; height:6px; border-radius:50%; }
        .tab-close { margin-left:auto; width:14px; height:14px; display:flex; align-items:center; justify-content:center; border-radius:2px; font-size:10px; color:#3d5a8a; transition:all .15s; }
        .tab-close:hover { background:#1e2a45; color:#f87171; }
        .tab-new { padding:6px 12px; color:#3d5a8a; cursor:pointer; font-size:16px; transition:color .15s; flex-shrink:0; }
        .tab-new:hover { color:#60a5fa; }

        /* Empty state */
        .empty-state { flex:1; display:flex; flex-direction:column; align-items:center; justify-content:center; color:#2a3a58; gap:12px; }
        .empty-logo { font-size:64px; opacity:.5; }
        .empty-title { font-size:18px; font-weight:600; color:#3d4f72; }
        .empty-sub { font-size:12px; color:#2a3a58; text-align:center; line-height:1.6; }
        .empty-hints { display:flex; gap:8px; flex-wrap:wrap; justify-content:center; margin-top:8px; }
        .hint-chip { padding:5px 12px; background:#111827; border:1px solid #1e2a45; border-radius:6px; font-size:11px; color:#3d5a8a; cursor:pointer; transition:all .2s; }
        .hint-chip:hover { border-color:#3b82f6; color:#60a5fa; }

        /* Terminal */
        .terminal { flex:1; background:#080c18; font-family:'JetBrains Mono','Fira Code',monospace; font-size:12.5px; line-height:1.55; padding:10px 12px; overflow-y:auto; cursor:text; }
        .terminal::-webkit-scrollbar { width:6px; }
        .terminal::-webkit-scrollbar-thumb { background:#1a2035; border-radius:3px; }
        .terminal-output { min-height:100%; display:flex; flex-direction:column; }
        .term-line { white-space:pre-wrap; word-break:break-all; color:#c8d3e8; }
        .term-line.input { color:#94a3b8; }
        .term-input-row { display:flex; align-items:center; margin-top:2px; }
        .term-prompt { white-space:nowrap; }
        .term-input { flex:1; background:transparent; border:none; outline:none; color:#e2e8f0; font-family:inherit; font-size:inherit; caret-color:#60a5fa; }

        /* SFTP panel */
        .sftp-panel { width:260px; background:#0a0e1a; border-left:1px solid #1a2035; display:flex; flex-direction:column; flex-shrink:0; overflow:hidden; }
        .sftp-header { background:#0d1120; padding:8px 10px; font-size:10px; font-weight:600; color:#3d4f72; letter-spacing:1px; text-transform:uppercase; border-bottom:1px solid #141c30; display:flex; align-items:center; justify-content:space-between; }
        .sftp-toolbar { display:flex; gap:2px; padding:4px 6px; border-bottom:1px solid #141c30; background:#0d1120; }
        .sftp-btn { padding:3px 6px; font-size:14px; background:transparent; border:none; cursor:pointer; color:#3d5a8a; border-radius:3px; transition:all .15s; }
        .sftp-btn:hover { background:#131d35; color:#60a5fa; }
        .sftp-path { padding:4px 8px; font-size:10px; color:#3d5a8a; font-family:'JetBrains Mono',monospace; border-bottom:1px solid #141c30; background:#080c18; }
        .sftp-tree { flex:1; overflow-y:auto; }
        .sftp-tree::-webkit-scrollbar { width:4px; }
        .sftp-tree::-webkit-scrollbar-thumb { background:#1e2a45; border-radius:2px; }
        .file-node { display:flex; align-items:center; gap:5px; padding:3px 8px; font-size:11px; color:#7a8fa8; cursor:pointer; font-family:'JetBrains Mono',monospace; transition:background .1s; }
        .file-node:hover { background:#0f1628; color:#a8bdd8; }
        .chevron { font-size:9px; width:10px; color:#3d5a8a; }
        .file-icon { font-size:12px; }
        .file-name { flex:1; white-space:nowrap; overflow:hidden; text-overflow:ellipsis; }
        .file-size { font-size:9px; color:#2a3a58; white-space:nowrap; }

        /* Notepad panel */
        .notepad-panel { width:280px; background:#0a0e1a; border-left:1px solid #1a2035; display:flex; flex-direction:column; flex-shrink:0; overflow:hidden; }
        .notepad-textarea { flex:1; background:#080c18; border:none; outline:none; color:#c8d3e8; font-family:'JetBrains Mono',monospace; font-size:12px; padding:10px; resize:none; line-height:1.6; }
        .notepad-textarea::placeholder { color:#2a3a58; }

        /* Status bar */
        .statusbar { height:22px; background:#0d1120; border-top:1px solid #1a2035; display:flex; align-items:center; padding:0 10px; gap:16px; font-size:10px; color:#2e3f60; flex-shrink:0; }
        .status-item { display:flex; align-items:center; gap:4px; }
        .status-dot { width:5px; height:5px; border-radius:50%; background:#22c55e; }
        .status-dot.off { background:#374151; }
        .status-right { margin-left:auto; display:flex; gap:16px; }

        /* Modal */
        .modal-overlay { position:fixed; inset:0; background:rgba(0,0,0,.75); display:flex; align-items:center; justify-content:center; z-index:100; backdrop-filter:blur(4px); }
        .modal { background:#0d1120; border:1px solid #1e2a45; border-radius:10px; width:480px; box-shadow:0 24px 80px rgba(0,0,0,.8); }
        .modal-header { padding:14px 16px; font-size:13px; font-weight:600; color:#8899bb; border-bottom:1px solid #141c30; display:flex; align-items:center; justify-content:space-between; }
        .modal-close { background:none; border:none; color:#3d5a8a; cursor:pointer; font-size:14px; padding:2px 6px; border-radius:3px; transition:all .15s; }
        .modal-close:hover { background:#1e2a45; color:#f87171; }
        .modal-body { padding:16px; max-height:70vh; overflow-y:auto; }
        .modal-body::-webkit-scrollbar { width:4px; }
        .modal-body::-webkit-scrollbar-thumb { background:#1e2a45; border-radius:2px; }
        .modal-tabs { display:flex; gap:4px; margin-bottom:16px; border-bottom:1px solid #141c30; padding-bottom:10px; }
        .modal-tab { padding:5px 14px; background:transparent; border:1px solid #1e2a45; border-radius:5px; font-size:11px; font-weight:600; color:#4a5f88; cursor:pointer; letter-spacing:.5px; transition:all .15s; }
        .modal-tab:hover { border-color:#2d4a7a; color:#8899bb; }
        .modal-tab.active { background:#1a2f55; border-color:#3b82f6; color:#60a5fa; }
        .form-grid { display:grid; grid-template-columns:90px 1fr; gap:8px 12px; align-items:center; }
        .form-grid label { font-size:11px; color:#4a5f88; text-align:right; }
        .form-grid input { background:#080c18; border:1px solid #1e2a45; border-radius:5px; padding:6px 10px; font-size:12px; color:#c8d3e8; outline:none; font-family:'JetBrains Mono',monospace; transition:border-color .15s; }
        .form-grid input:focus { border-color:#3b82f6; }
        .modal-footer { padding:12px 16px; border-top:1px solid #141c30; display:flex; justify-content:flex-end; gap:8px; }
        .btn-cancel { padding:7px 16px; background:transparent; border:1px solid #1e2a45; border-radius:6px; font-size:12px; color:#4a5f88; cursor:pointer; transition:all .15s; }
        .btn-cancel:hover { border-color:#2d4a7a; color:#8899bb; }
        .btn-connect { padding:7px 20px; background:#1d4ed8; border:none; border-radius:6px; font-size:12px; color:#fff; cursor:pointer; font-weight:600; transition:all .15s; }
        .btn-connect:hover { background:#2563eb; }
        .new-btn { display:flex; align-items:center; gap:3px; padding:2px 8px; background:transparent; border:1px solid #1e2640; border-radius:3px; font-size:11px; color:#3d5a8a; cursor:pointer; transition:all .15s; }
        .new-btn:hover { border-color:#3b82f6; color:#60a5fa; }

        /* Settings */
        .settings-section { background:#080c18; border-radius:8px; padding:14px; border:1px solid #1a2035; }
        .settings-title { font-size:10px; font-weight:700; color:#3d4f72; letter-spacing:1px; text-transform:uppercase; margin-bottom:10px; }

        /* Context menu */
        .ctx-menu { position:fixed; background:#0d1120; border:1px solid #1e2640; border-radius:7px; min-width:160px; padding:4px; box-shadow:0 12px 40px rgba(0,0,0,.8); z-index:500; }
        .ctx-item { display:flex; align-items:center; gap:8px; padding:7px 12px; font-size:12px; cursor:pointer; border-radius:4px; transition:background .1s; }
        .ctx-item:hover { background:#1e2a45; }
        .ctx-icon { font-size:13px; width:16px; text-align:center; }
        .ctx-divider { height:1px; background:#1a2035; margin:4px 0; }

        /* Tunnel / Key rows */
        .tunnel-row, .key-row { display:flex; align-items:center; gap:10px; padding:10px 0; border-bottom:1px solid #141c30; }
        .tunnel-row:last-child, .key-row:last-child { border-bottom:none; }
      `}</style>

      {/* Titlebar */}
      <div className="titlebar">
        <div className="traffic-lights">
          <div className="tl tl-red" onClick={() => activeTab && closeTab(activeTab)} title="Close tab" />
          <div className="tl tl-yellow" title="Minimize" />
          <div className="tl tl-green" title="Fullscreen" />
        </div>
        <div className="titlebar-title">
          {activeTabData ? `${activeTabData.name} — MobaXterm for Mac` : "MobaXterm for Mac"}
        </div>
      </div>

      {/* Menubar */}
      <div className="menubar" ref={menuRef}>
        {Object.entries(menus).map(([name, items]) => (
          <div key={name} className={`menu-item ${activeMenu === name ? "open" : ""}`}
            onClick={() => setActiveMenu(activeMenu === name ? null : name)}>
            {name}
            {activeMenu === name && (
              <div className="menu-dropdown">
                {items.map((item, i) => item.divider
                  ? <div key={i} className="menu-dd-divider" />
                  : <div key={i} className="menu-dd-item" onClick={() => { item.action(); setActiveMenu(null); }}>
                      <span>{item.label}</span>
                      {item.shortcut && <span className="menu-dd-shortcut">{item.shortcut}</span>}
                    </div>
                )}
              </div>
            )}
          </div>
        ))}
      </div>

      {/* Toolbar */}
      <div className="toolbar">
        <button className="tb-btn" onClick={() => setShowModal(true)} title="New Session (⌘N)">
          <span className="tb-icon">⊕</span><span>Session</span>
        </button>
        <button className="tb-btn" onClick={openLocalTerminal} title="Local Terminal (⌘T)">
          <span className="tb-icon">🖥️</span><span>Shell</span>
        </button>
        <button className={`tb-btn ${showSFTP ? "active" : ""}`} onClick={() => setShowSFTP(s => !s)} title="Toggle SFTP (⌘B)">
          <span className="tb-icon">📁</span><span>SFTP</span>
        </button>
        <div className="tb-sep" />
        <button className="tb-btn" onClick={() => setShowKeys(true)} title="SSH Key Manager">
          <span className="tb-icon">🔑</span><span>Keys</span>
        </button>
        <button className="tb-btn" onClick={() => setShowTunnel(true)} title="Port Tunnels">
          <span className="tb-icon">🔧</span><span>Tunnel</span>
        </button>
        <button className="tb-btn" title="X Server (requires XQuartz)">
          <span className="tb-icon">📊</span><span>X server</span>
        </button>
        <div className="tb-sep" />
        <button className={`tb-btn ${showNotepad ? "active" : ""}`} onClick={() => setShowNotepad(s => !s)} title="Notepad">
          <span className="tb-icon">📝</span><span>Notepad</span>
        </button>
        <button className="tb-btn" title="Macros (coming soon)">
          <span className="tb-icon">⌨️</span><span>Macros</span>
        </button>
        <div className="tb-sep" />
        <button className={`tb-btn ${showSFTP ? "active" : ""}`} onClick={() => setShowSFTP(s => !s)} title="Toggle Browser (⌘B)">
          <span className="tb-icon">📂</span><span>Browser</span>
        </button>
        <button className="tb-btn" onClick={() => setShowSettings(true)} title="Settings">
          <span className="tb-icon">⚙️</span><span>Settings</span>
        </button>
      </div>

      {/* Main layout */}
      <div className="main-layout">

        {/* Sidebar */}
        {showSidebar && (
          <div className="sidebar" style={{ width:sidebarWidth }}>
            <div className="sidebar-header">
              <span>Sessions</span>
              <button className="new-btn" onClick={() => setShowModal(true)}>+ New</button>
            </div>
            <div className="sidebar-search">
              <div className="search-wrap">
                <input
                  placeholder="Search sessions..."
                  value={searchQuery}
                  onChange={e => setSearchQuery(e.target.value)}
                />
              </div>
            </div>
            <div className="sidebar-scroll">
              {filteredSessions.map(group => (
                <div key={group.id}>
                  <div className="group-header" onClick={() => setExpandedGroups(g => ({ ...g, [group.id]: !g[group.id] }))}>
                    <span className={`group-arrow ${expandedGroups[group.id] ? "open" : ""}`}>▶</span>
                    <span>📁 {group.name}</span>
                    <span style={{ marginLeft:"auto", fontSize:9, color:"#2a3a58" }}>{group.children.length}</span>
                  </div>
                  {expandedGroups[group.id] && group.children.map(sess => (
                    <div key={sess.id}
                      className={`session-item ${activeTabData?.id === sess.id ? "active" : ""}`}
                      onClick={() => setSelectedSession(sess)}
                      onDoubleClick={() => openSession(sess)}
                      onContextMenu={(e) => {
                        e.preventDefault(); e.stopPropagation();
                        setContextMenu({ x: e.clientX, y: e.clientY, session: sess });
                      }}
                    >
                      <div className="session-dot" style={{ background:sess.color }} />
                      {renamingId === sess.id
                        ? <input ref={renameRef} className="rename-input" value={renameVal}
                            onChange={e => setRenameVal(e.target.value)}
                            onBlur={() => commitRename(sess.id)}
                            onKeyDown={e => { if (e.key==="Enter") commitRename(sess.id); if (e.key==="Escape") setRenamingId(null); }}
                            onClick={e => e.stopPropagation()} />
                        : <span style={{ flex:1, overflow:"hidden", textOverflow:"ellipsis", whiteSpace:"nowrap" }}>{sess.name}</span>
                      }
                      <span className="session-type-badge">{sess.type}</span>
                    </div>
                  ))}
                </div>
              ))}
              {filteredSessions.every(g => g.children.length === 0) && searchQuery && (
                <div style={{ color:"#2a3a58", fontSize:11, padding:"16px", textAlign:"center" }}>No sessions match "{searchQuery}"</div>
              )}
            </div>
            {selectedSession && (
              <div style={{ padding:"8px 10px", borderTop:"1px solid #141c30", fontSize:10, color:"#3d5a8a", background:"#080c18" }}>
                <div style={{ color:"#5577aa", fontWeight:600, marginBottom:4 }}>{selectedSession.name}</div>
                <div>Host: {selectedSession.host}{selectedSession.port !== 22 ? `:${selectedSession.port}` : ""}</div>
                <div>User: {selectedSession.user}</div>
                <div>Type: {selectedSession.type.toUpperCase()}</div>
                <div style={{ marginTop:6, display:"flex", gap:4 }}>
                  <button className="btn-connect" style={{ fontSize:10, padding:"4px 10px", flex:1 }}
                    onClick={() => openSession(selectedSession)}>▶ Connect</button>
                  <button className="btn-cancel" style={{ fontSize:10, padding:"4px 10px" }}
                    onClick={() => { setEditSession(selectedSession); setShowModal(true); }}>✎</button>
                </div>
              </div>
            )}
          </div>
        )}

        {/* Resize handle */}
        {showSidebar && (
          <div className={`resize-handle ${dragging ? "dragging" : ""}`} onMouseDown={() => setDragging(true)} />
        )}

        {/* Content area */}
        <div className="content-area">
          <div className="tabbar">
            {tabs.map(tab => (
              <div key={tab.tabId} className={`tab ${activeTab === tab.tabId ? "active" : ""}`}
                onClick={() => setActiveTab(tab.tabId)}>
                <div className="tab-dot" style={{ background:tab.color }} />
                <span>{tab.name}</span>
                <span style={{ fontSize:9, color:"#2a3a58", marginLeft:2 }}>({tab.host})</span>
                <div className="tab-close" onClick={e => closeTab(tab.tabId, e)}>✕</div>
              </div>
            ))}
            <div className="tab-new" onClick={() => setShowModal(true)} title="New session (⌘N)">＋</div>
          </div>

          {activeTabData ? (
            <Terminal key={activeTabData.tabId} session={activeTabData} settings={settings} onClear={clearSignal} />
          ) : (
            <div className="empty-state">
              <div className="empty-logo">⚡</div>
              <div className="empty-title">MobaXterm for Mac</div>
              <div className="empty-sub">Double-click a session to connect<br />or create a new one to get started</div>
              <div className="empty-hints">
                <div className="hint-chip" onClick={() => setShowModal(true)}>＋ New SSH Session</div>
                <div className="hint-chip" onClick={openLocalTerminal}>⌨️ Local Terminal</div>
                <div className="hint-chip" onClick={() => setShowTunnel(true)}>🔧 Port Tunnel</div>
                <div className="hint-chip" onClick={() => { if (tabs.length > 0) setShowSFTP(true); else setShowModal(true); }}>📁 SFTP Browser</div>
              </div>
              <div style={{ marginTop:24, fontSize:10, color:"#1e2a45", textAlign:"center", lineHeight:1.8 }}>
                <div>💡 Double-click sessions in the left panel to connect</div>
                <div>💡 Right-click a session for more options</div>
                <div>💡 Type <span style={{ color:"#3d5a8a" }}>help</span> in terminal for available commands</div>
              </div>
            </div>
          )}
        </div>

        {/* SFTP Panel */}
        {showSFTP && activeTabData && (
          <div className="sftp-panel">
            <div className="sftp-header">
              <span>SFTP — {activeTabData.host}</span>
              <button className="modal-close" onClick={() => setShowSFTP(false)}>✕</button>
            </div>
            <div className="sftp-toolbar">
              <button className="sftp-btn" title="Upload">⬆️</button>
              <button className="sftp-btn" title="Download">⬇️</button>
              <button className="sftp-btn" title="New Folder">📁</button>
              <button className="sftp-btn" title="Delete">🗑️</button>
              <button className="sftp-btn" title="Refresh">🔄</button>
              <button className="sftp-btn" title="Home">🏠</button>
            </div>
            <div className="sftp-path">/home/{activeTabData.user}</div>
            <div className="sftp-tree">
              {fileTree.map((node, i) => (
                <FileNode key={i} node={node} onToggle={toggleFileNode} />
              ))}
            </div>
          </div>
        )}

        {/* Notepad Panel */}
        {showNotepad && (
          <NotepadPanel content={notepadContent} onChange={setNotepadContent} onClose={() => setShowNotepad(false)} />
        )}
      </div>

      {/* Status bar */}
      <div className="statusbar">
        <div className="status-item">
          <div className={`status-dot ${tabs.length > 0 ? "" : "off"}`} />
          <span>{tabs.length} session{tabs.length !== 1 ? "s" : ""} active</span>
        </div>
        {tunnels.length > 0 && <div className="status-item">🔧 {tunnels.length} tunnel{tunnels.length !== 1 ? "s" : ""}</div>}
        {activeTabData && (
          <>
            <div className="status-item">🖥️ {activeTabData.host}:{activeTabData.port}</div>
            <div className="status-item">👤 {activeTabData.user}</div>
            <div className="status-item">🔒 {activeTabData.type.toUpperCase()}</div>
          </>
        )}
        <div className="status-right">
          <span>{settings.fontFamily} · {settings.fontSize}px</span>
          <span>UTF-8</span>
          <span>LF</span>
        </div>
      </div>

      {/* Modals & overlays */}
      {showModal && (
        <NewSessionModal
          initial={editSession}
          onClose={() => { setShowModal(false); setEditSession(null); }}
          onConnect={editSession ? (s) => { saveEditSession(s); setEditSession(null); } : addNewSession}
        />
      )}
      {showSettings  && <SettingsModal settings={settings} onChange={setSettings} onClose={() => setShowSettings(false)} />}
      {showTunnel    && <TunnelModal tunnels={tunnels} onAdd={t => setTunnels(tt => [...tt, t])} onDelete={id => setTunnels(tt => tt.filter(t => t.id !== id))} onClose={() => setShowTunnel(false)} />}
      {showKeys      && <KeysModal keys={sshKeys} onAdd={k => setSshKeys(kk => [...kk, k])} onDelete={id => setSshKeys(kk => kk.filter(k => k.id !== id))} onClose={() => setShowKeys(false)} />}
      {showShortcuts && <ShortcutsModal onClose={() => setShowShortcuts(false)} />}
      {showAbout     && <AboutModal onClose={() => setShowAbout(false)} />}

      {/* Context menu */}
      {contextMenu && (
        <ContextMenu
          x={contextMenu.x} y={contextMenu.y} session={contextMenu.session}
          onClose={() => setContextMenu(null)}
          onConnect={() => openSession(contextMenu.session)}
          onDuplicate={() => duplicateSession(contextMenu.session)}
          onRename={() => startRename(contextMenu.session)}
          onDelete={() => deleteSession(contextMenu.session.id)}
        />
      )}
    </div>
  );
}
