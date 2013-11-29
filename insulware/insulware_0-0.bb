DESCRIPTION = "Firmware for medical device (esp. insulin pumps/BGM) auditing"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=73f1eb20517c55bf9493b7dd6e480788"

SRCREV = "340ccc8cca73d8f0fbee4a536291921434735320"
SRC_URI = "git://github.com/n-west/insulware.git"

RDEPENDS_insulware += "cmgpy"

S = "${WORKDIR}/git"

FILES_${PN} = "/usr /lib /etc /home"

do_install() {
 install -d ${D}/home/new ${D}/lib/systemd/scripts ${D}/etc/ppp/peers ${D}/usr/bin

 cp -r ${S}/deploy/* ${D}/

}
