DESCRIPTION = "Firmware for medical device (esp. insulin pumps/BGM) auditing"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=73f1eb20517c55bf9493b7dd6e480788"

SRCREV = "${AUTOREV}"
SRC_URI = "git://github.com/n-west/insulware.git"

RDEPENDS_insulware += "cmgpy python python-pyserial"

S = "${WORKDIR}/git"

FILES_${PN} = "/usr /lib /etc /home"

do_install() {
 install -d ${D}/home/new ${D}/lib/systemd/scripts ${D}/etc/ppp/peers ${D}/usr/bin

 cp -r ${S}/deploy/* ${D}/

}
