package dev.elvir.morecommunication.ext

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import dev.elvir.morecommunication.R

@JvmOverloads
fun FragmentActivity.addFragment(
    fragment: Fragment,
    container: Int = R.id.fmt_container,
    addToBackStack: Boolean = false,
    tag: String = fragment.javaClass.simpleName,
    allowStateLoss: Boolean = false
): Int =
    supportFragmentManager.beginTransaction()
        .add(container, fragment, tag)
        .apply {
            if (addToBackStack) {
                addToBackStack(null)
            }
        }.let { transaction ->
            if (allowStateLoss) {
                transaction.commitAllowingStateLoss()
            } else {
                transaction.commit()
            }
        }

@JvmOverloads
fun FragmentActivity.replaceFragment(
    fragment: Fragment,
    container: Int = R.id.fmt_container,
    tag: String = fragment.javaClass.simpleName,
    allowStateLoss: Boolean = false
): Int = supportFragmentManager
    .beginTransaction()
    .replace(container, fragment, tag)
    .addToBackStack(null)
    .let { if (allowStateLoss) it.commitAllowingStateLoss() else it.commit() }

@JvmOverloads
fun FragmentActivity.replaceFragmentWithoutBack(
    fragment: Fragment,
    container: Int = R.id.fmt_container,
    tag: String = fragment.javaClass.simpleName,
    allowStateLoss: Boolean = false
): Int = supportFragmentManager
    .beginTransaction()
    .replace(container, fragment, tag)
    .let { if (allowStateLoss) it.commitAllowingStateLoss() else it.commit() }

fun FragmentActivity.popBackStackOrFinish() =
    if (supportFragmentManager.backStackEntryCount > 0)
        supportFragmentManager.popBackStack()
    else
        finish()