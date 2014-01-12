# This ships an avahi conf file that disallowed foreign stacks since mDNS 
# isn't supported until linux 3.8ish

FILESEXTRAPATHS_prepend := "${THISDIR}/avahi:"
SRC_URI += "file://avahi-daemon.conf"

do_install_append() {
    install -m 0644 ${WORKDIR}/avahi-daemon.conf ${D}${sysconfdir}/avahi/avahi-daemon.conf
}
