DESCRIPTION = "A Python AT library specializing in SMS handling"
HOMEPAGE = "http://nathanwest.us"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://../LICENSE;md5=d32239bcb673463ab874e80d47fae504"

PR = "r1"

DEPENDS = "python-pyserial"

SRCREV="579737c3e2fbf0d14b1bb81877876d394f802f82"
SRC_URI = "git://github.com/n-west/cmgpy.git"

S = "${WORKDIR}/git/src"

FILES_${PN} = "${libdir}/python2.7"

do_install () {
 install -d ${D}${libdir}/python2.7/cmgpy
 echo "cp -r ${S}/cmgpy/ ${D}${libdir}/python2.7/"
 cp -r ${S}/cmgpy ${D}${libdir}/python2.7/
}

