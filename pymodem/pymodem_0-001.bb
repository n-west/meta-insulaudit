DESCRIPTION = "A Python AT library specializing in SMS handling"
HOMEPAGE = "http://nathanwest.us"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://../LICENSE;md5=d32239bcb673463ab874e80d47fae504"

PR = "r0"

DEPENDS = "python-pyserial"

SRCREV="2d87e222c3b30517898a0071da718b5cfa618874"
SRC_URI = "git://github.com/n-west/unapy.git"

S = "${WORKDIR}/git/src"

FILES_${PN} = "${libdir}/python2.7"

do_install () {
 install -d ${D}${libdir}/python2.7/pymodem
 echo "cp -r ${S}/pymodem/ ${D}${libdir}/python2.7/"
 cp -r ${S}/pymodem ${D}${libdir}/python2.7/
}

