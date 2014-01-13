DESCRIPTION = "udev tools for hso Zero CD"
HOMEPAGE = "http://pharscape.org/ozerocdoff.html"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://README;md5=0f82c8dcf290f144d025acf6b1ed312d"

DEPENDS = "udev libusb-compat"

SRCREV = "a6d42af47796740120419d5eceaaee68e1c1d39d"
SRC_URI = "git://github.com/n-west/udev-hso.git;protocol=https"

S = "${WORKDIR}/git"
do_compile () {
  make
}
do_install () {
  DESTDIR=${D} oe_runmake install
}

FILES_${PN} += "${datadir}/usr/*"
