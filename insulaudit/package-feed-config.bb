DESCRIPTION = "Configuration files for online package repositories aka feeds; adopted from angstrom"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

#PV = "${DISTRO_VERSION}"
PR = "r0"
PACKAGE_ARCH = "${MACHINE_ARCH}"

FEED_BASEPATH ?= "feeds/"

IWMMXT_FEED = "${@base_contains('MACHINE_FEATURES', 'iwmmxt', 'iwmmxt', '',d)}"

do_compile() {
	mkdir -p ${S}/${sysconfdir}/opkg

	for feed in base debug perl python gstreamer ; do
		  echo "src/gz ${feed} ${MEDEVICE_URI}/${FEED_BASEPATH}${FEED_ARCH}/${feed}" > ${S}/${sysconfdir}/opkg/${feed}-feed.conf
	done

	echo "src/gz ${MACHINE_ARCH} ${MEDEVICE_URI}/${FEED_BASEPATH}${FEED_ARCH}/machine/${MACHINE_ARCH}" >  ${S}/${sysconfdir}/opkg/${MACHINE_ARCH}-feed.conf
	echo "#src/gz sdk ${MEDEVICE_URI}/${FEED_BASEPATH}sdk" > ${S}/${sysconfdir}/opkg/sdk-feed.conf
	echo "src/gz no-arch ${MEDEVICE_URI}/${FEED_BASEPATH}all" > ${S}/${sysconfdir}/opkg/noarch-feed.conf
		
	# iwmmxt is a special case, add the iwmmxt feed for machine that have 'iwmmxt' in MACHINE_FEATURES
		if [ "${IWMMXT_FEED}" = "iwmmxt" ] ; then
	  echo "src/gz iwmmxt ${MEDEVICE_URI}/${FEED_BASEPATH}iwmmxt/base" > ${S}/${sysconfdir}/opkg/iwmmxt-feed.conf
	fi  


	for localepkg in a af am an ang ar as ast ay az be bg bn br bs byn ca co crh cs csb cy da de dv dz el en eo es et eu fa ff fi fo fr fur fy ga gd gez gl gn gu gv ha haw he hi hr hsb ht hu hy ia id ig io is it iu iw ja ka kk kl km kn ko kok ks ku kw ky la lg li lo locale lt lv mai mg mi mk ml mn mr ms mt mvo my nb ne nl nn no nr nso oc om or pa pap pis pl ps pt qu ro ru rw sa sd se si sid sk sl so sp sq sr ss st sv sw syr ta te tet tg th ti tig tk tl tn tpi tr ts tt ug uk ur uz ve vi wa wal wo xh yi yo zh zu ; do
		echo "src/gz locale-${localepkg}-feed ${MEDEVICE_URI}/${FEED_BASEPATH}${FEED_ARCH}/locales/${localepkg}" > ${S}/${sysconfdir}/opkg/locale-${localepkg}-feed.conf
	done
}


do_install () {
	install -d ${D}${sysconfdir}/opkg
	install -m 0644  ${S}/${sysconfdir}/opkg/* ${D}${sysconfdir}/opkg/
}

FILES_${PN} = "${sysconfdir}/opkg/base-feed.conf \
					${sysconfdir}/opkg/debug-feed.conf \
					${sysconfdir}/opkg/perl-feed.conf \
					${sysconfdir}/opkg/python-feed.conf \
					${sysconfdir}/opkg/gstreamer-feed.conf \
					${sysconfdir}/opkg/${MACHINE_ARCH}-feed.conf \
					${sysconfdir}/opkg/noarch-feed.conf \
					${sysconfdir}/opkg/iwmmxt-feed.conf \
					${sysconfdir}/opkg/sdk-feed.conf \
					"
