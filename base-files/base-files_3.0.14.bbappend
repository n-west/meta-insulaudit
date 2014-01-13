
FILESEXTRAPATHS_prepend := "${THISDIR}/base-files:"

PRINC := "${@int(PRINC) + 0}"


SRC_URI += "\
            file://interfaces \
          "

do_install_append_medevice() {
    install -d -m 755 ${D}${sysconfdir}
    install -m 0644 ${WORKDIR}/interfaces ${D}${sysconfdir}/network/interfaces
}
