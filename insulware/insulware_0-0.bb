DESCRIPTION = "Firmware for medical device (esp. insulin pumps/BGM) auditing"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=73f1eb20517c55bf9493b7dd6e480788"

SRCREV = "21cf37fc7d19bbfcddf502e9b529ddfa1c3b069b"
SRC_URI = "git://github.com/n-west/insulware.git"

RDEPENDS += "pymodem"

S = "${WORKDIR}/git"

FILES_${PN} = "/usr /lib /etc /home"

do_install() {
 install -d ${D}/home/new ${D}/lib/systemd/scripts ${D}/etc/ppp/peers ${D}/usr/bin

 cp -r ${S}/deploy/* ${D}/

}
